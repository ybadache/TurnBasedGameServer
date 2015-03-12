/*******************************************************************************
 * This application simulates turn-based games hosted on a server.
 *     Copyright (C) 2014 
 *     Initiators : Fabien Delecroix and Yoann Dufresne
 *     Developpers : Raphael Bauduin and Celia Cacciatore
 * 
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * 
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 * 
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/

package main.java.model.engine;

import java.util.List;

import serverComponents.ServerRequest;
import main.java.clients.ClientFactory;
import main.java.clients.ClientInterface;
import main.java.model.Game;
import main.java.model.exceptions.GameException;
import main.java.model.moves.Move;
import main.java.model.moves.MoveFactory;
import main.java.model.players.Player;

/**
 * Hosts the game :</br>
 * - Can create the game</br>
 * - Asks for players</br>
 * - Creates all that's necessary to play the game</br>
 * - Plays</br>
 * 
 * @author Cacciatore Celia - Bauduin Raphael
 *
 * @param <G>
 */
public abstract class GameHost<G extends Game> {
	
	protected List<Player> players;
	protected G game;
	protected MoveFactory<G> firstMoveFactory;
	protected ClientInterface clientInterface;

	/**
	 * Creates a host for the game.
	 * @param n number of players
	 */
	public GameHost(int n, ClientFactory clientFactory) {
		this.clientInterface = new ClientInterface(clientFactory);
		this.askForPlayers(n);
		this.createGame();
		this.createFactories();
	}
	
	/**
	 * Creates a game and stores it.
	 */
	protected abstract void createGame();
	
	/**
	 * Creates all the move factories and stores the first one in the chain of responsibility.
	 */
	protected abstract void createFactories();
	
	/**
	 * Asks for n players to join the game.
	 * @param n number of players
	 */
	private void askForPlayers(int n) {
		this.players = this.clientInterface.waitForPlayers(n);
	}
	
	/**
	 * Plays the game.
	 */
	public void playGame(ServerRequest servRequest) {
		while (!game.isFinished()) {
			boolean correctMove = false;	
			do {
				Player player = game.getCurrentPlayer();
				try {
					// Create move from the message
					
					String msg = this.clientInterface.receiveMessage(player, servRequest);
					Move<G> move = (Move<G>)(this.firstMoveFactory.receive(msg));
					// Play move
					System.out.println("Joue le move");
					game.play(move, player);
					correctMove = true;
					System.out.println("Envoie le move");
					this.clientInterface.sendPlayedMove(move.getDescription(), player, servRequest);
				} catch (GameException e) {
					this.clientInterface.sendError(e.getErrorCode(), player, servRequest);
				} catch (Exception e) {
					e.printStackTrace();
					System.exit(0);
				}
			} while (!correctMove);
		}
		// The game is finished
		this.clientInterface.sendEnd(game.getWinners(), servRequest);
		this.clientInterface.closeConnections(servRequest);
	}
}
