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
 * Sends a message to the client, when he uses a bad command -to correct-
 * or when the command isn't implemented yet
 * 
 * @author YBADACHE
 *
 */
public class RequestNYI implements Request {
	@Override
	public void processRequest(RequestHandler request)
	{	
		request.writer.flush();
		request.writer.println("Not yet implemented !");
		request.writer.flush();
		return;
	}

}
