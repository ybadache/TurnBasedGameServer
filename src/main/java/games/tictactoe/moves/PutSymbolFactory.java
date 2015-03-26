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

package main.java.games.tictactoe.moves;

import main.java.games.tictactoe.TicTacToe;
import main.java.games.tictactoe.exceptions.GridIndexOutOfBoundsException;
import main.java.model.exceptions.IncorrectNumberOfArgumentsException;
import main.java.model.exceptions.IncorrectTypesOfArgumentException;
import main.java.model.moves.Move;
import main.java.model.moves.MoveFactory;

/**
 * Creates the move which puts a symbol in a TicTacToe grid.
 * 
 * @author Celia Cacciatore - Raphael Bauduin
 */
public class PutSymbolFactory extends MoveFactory<TicTacToe> {
	
	@Override
	public boolean correctKeyword(String message) {
		return message.split(" ")[0].equals("put");
	}
	
	@Override
	public Move<TicTacToe> create(String message) throws Exception {
		String[] args = message.split(" ");
		// Creation of PutSymbol move
		int x, y;
		try {
			// Coordinates in the grid
			x = Integer.parseInt(args[1]);
			y = Integer.parseInt(args[2]);
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new IncorrectNumberOfArgumentsException();
		} catch (NumberFormatException e) {
			throw new IncorrectTypesOfArgumentException();
		}
		// Test : coordinates in the grid ?
		if (x < 0 || y < 0 || x > 2 || y > 2) {
			throw new GridIndexOutOfBoundsException();
		}
		return new PutSymbol(x, y);
	}
}