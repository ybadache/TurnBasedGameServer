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

package serverRequestTreatment;

import java.io.IOException;

import serverComponents.RequestHandler;

/**
 * Not implemented, but should allow a player to
 * join a game already created on the server.
 * 
 * @author YBADACHE
 *
 */
public class RequestJOIN implements Request
{
	@Override
	public void processRequest (RequestHandler request)
	{
		request.writer.flush();
		request.writer.println("Connected: " + request.connected);
		request.writer.flush();
		
		// System.out.println(System.getenv());
		
		String[] command = {"CMD", "/C", "TicTacToe.jar"};
		ProcessBuilder pb = new ProcessBuilder (command);
		
		try {
			Process p = pb.start();
			pb.inheritIO();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return;
	}

	@Override
	public void treatError() {
		// TODO Auto-generated method stub
		
	}

}
