/*******************************************************************************
 * This server holds all the components so the
 * specified client will be able to communicate with it to run, create, join
 * or leave a game that the server allows. It also implements the game factory
 * TurnBasedGame, created by Raphael Bauduin and Celia Cacciatore last year.
 * 
 *     Copyright (C) 2015 
 *     Initiators : Gauvin Marquet and Yoann Dufresne
 *     Developper : Yassine Badache
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

package serverRequest;

import serverComponents.RequestHandler;

/**
 * Treats the CREATE request. Case sensitivity is ON at the moment so the client
 * have to type exactly "create <game>" to make it work, and "create" to access
 * this part of the server.
 * 
 * @author Yassine Badache
 *
 */
public class RequestCREATE implements Request {
	@Override
	public void processRequest(RequestHandler request) {
		// request.query[0] is the command, request.query[1] is the
		// name of the game that you want to run
		if (!(request.query[1].isEmpty())) {
			switch (request.query[1]) {
			case ("tictactoe"):
				// Using the built game from TurnBasedGame
				break;

				// Not Yet Implemented: running other games
			/*
			 * case("isola"): IsolaHost isola = new IsolaHost ();
			 * isola.playGame(); break;
			 * 
			 * case ("potato"): HotPotatoHost hotPotato = new HotPotatoHost();
			 * hotPotato.playGame(); break;
			 */

			default:
				request.writer.println("Unknown game");
				break;
			}
		}

		// Client will receive this if he didn't use the command correctly
		else {
			request.writer
					.println("Bad use of command 'create', use 'create <game>' (check also that the game is runnable by typing 'list'");
			request.writer.flush();
			return;
		}

		return;
	}

}
