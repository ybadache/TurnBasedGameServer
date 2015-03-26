/*******************************************************************************
 * Holds all the components so the
 * specified client will be able to communicate with it to run, create, join
 * or leave a game that the server allows.
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

package serverComponents;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Is used as a starting point for all the clients, with multi-thread
 * compatibility.
 * 
 * @author Yassine Badache
 *
 */
public class Server extends Thread {
	public Socket socket;
	public ServerSocket servSocket;

	/**
	 * Initialization of the server socket's port.
	 * 
	 * @param port
	 *            Port number on which we will connect
	 */
	public void init(int port) {
		try {
			this.servSocket = new ServerSocket(port);
			System.out.println("Socket succesfully launched at port " + port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		while (true) {
			System.out.println("Waiting for client ...");
			try {
				this.socket = this.servSocket.accept();
				new Thread(new ServerRequest(this.socket)).run();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public ServerSocket getServSocket() {
		return servSocket;
	}

	public void setServSocket(ServerSocket servSocket) {
		this.servSocket = servSocket;
	}
}
