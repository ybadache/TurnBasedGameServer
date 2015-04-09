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

package main.java.model.players;

import java.util.Iterator;
import java.util.List;

/**
 * Enables to play a game with an immutable order of the players.
 * 
 * @author Cacciatore Celia - Bauduin Raphael
 */
public class Ordered extends PlayersOrder {

	private Iterator<Player> iterator;
	
	public Ordered(List<Player> players) {
		super(players);
		this.iterator = this.players.iterator();
	}
	
	@Override
	public Player getCurrentPlayer() {
		if (!this.iterator.hasNext()) {
			this.iterator = this.players.iterator();
		}
		return this.iterator.next();
	}
}