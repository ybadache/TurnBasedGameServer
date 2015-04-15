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
 * Creates the right command considering the parameter request.query[0], which
 * is the name of the command sent by the client to the server.
 * 
 * @author Yassine Badache
 *
 */
public class RequestCreation {

	public void createRequest(RequestHandler request) {
		System.out.println(request.query[0]);

		switch (request.query[0]) {
		case ("list"):
			System.out.println("list request");
			new RequestLIST().processRequest(request);
			break;

		case ("join"):
			System.out.println("join request");
			new RequestJOIN().processRequest(request);
			break;

		case ("leave"):
			System.out.println("leave request");
			new RequestLEAVE().processRequest(request);
			break;

		case ("exit"):
			System.out.println("exit request");
			new RequestEXIT().processRequest(request);
			break;

		case ("help"):
			System.out.println("help request");
			new RequestHELP().processRequest(request);
			break;

		// A request also exists in case of bad input or non-existing command
		default:
			System.out.println("nyi request");
			new RequestNYI().processRequest(request);
			break;
		}

	}
}
