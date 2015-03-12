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

package main.java.clients.local;

import java.io.IOException;

import main.java.clients.Client;
import serverComponents.ServerRequest;

/**
 * A local client playing.
 * 
 * @author Cacciatore Celia - Bauduin Raphael
 */
public class LocalClient implements Client {

	@Override
	public String sendMessageWithAnswer(String receivedMessage, ServerRequest servRequest) {
		System.out.println("OH TU VIENS ?!");
		servRequest.writer.println(receivedMessage);
		servRequest.writer.flush();
		String message = null;
		try {
			message = servRequest.reader.readLine();
		} catch (IOException e) {
			message = "Unable to read line";
		}
		
		return message;
	}

	@Override
	public void sendMessage(String message, ServerRequest servRequest) {
		System.out.println(message + " dans le SendMessage");
		servRequest.writer.println(message);
		servRequest.writer.flush();
	}

	@Override
	public void closeConnection(ServerRequest servRequest) {
		try {
			servRequest.reader.close();
			servRequest.writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
}