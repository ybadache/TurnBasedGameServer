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

package serverComponents;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import serverRequest.RequestCreation;

/**
 * Receives the request sent by the client and treats it by sending it into the
 * Factory pattern. Also has a raw game list initialization .
 * 
 * @author Yassine Badache
 *
 */

public class ServerRequest implements Runnable {
	/** Socket used by the request to connect to the server */
	public Socket requestSocket;
	/** Reader in order to read data sent by the client */
	public BufferedReader reader;
	/** Writer used to response to the client */
	public PrintWriter writer;
	/** Data stream used with the BufferedReader */
	public DataInputStream dataReader;
	/** Output stream used with the PrintWriter */
	public DataOutputStream dataWriter;
	/** Holds the available game -for the moment, raw data- */
	private ArrayList<String> gameList;
	/** Will receive the query to be cut into parts and treated lately */
	public String[] query;

	/**
	 * Classic constructor which will initialize all the variables and notices
	 * the client that the service is ready. If the client doesn't receive the
	 * message sent by the 'this.writer.println()', you shall check from the
	 * scratch for any network problem.
	 */
	public ServerRequest(Socket socket) {
		this.requestSocket = socket;
		this.gameList = new ArrayList<String>();
		try {
			this.reader = new BufferedReader(new InputStreamReader(
					this.requestSocket.getInputStream()));
			this.writer = new PrintWriter(this.requestSocket.getOutputStream());
			this.writer.println("[SERVER] Game service ready !");
			this.writer.flush();
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Raw data, that can be modified later. UPGRADES TO DO: StringBuffers and
	 * dynamic filling of the game list with the factories ?
	 */
	public void initGameList() {
		this.gameList.add("Patate_chaude");
		this.gameList.add("Isola");
		this.gameList.add("Morpion");
	}

	/**
	 * Runs the request, initializing the game list and running the
	 * processRequest(), where all the commands will be received from the
	 * client.
	 */
	public void run() {
		try {
			// Game list initialized
			this.initGameList();

			// Processing the incoming request from the client
			this.processRequest();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			this.requestSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Treats the request by splitting it in pieces and sending the request to
	 * the Factory pattern, in order to access the right command.
	 * 
	 * @throws IOException
	 *             When the reader encounters a problem.
	 */
	public void processRequest() throws IOException {
		String input;
		while ((input = reader.readLine()) != "exit") {
			// Splitting the command and sending the request to the factory
			this.query = input.split("\\s+");
			new RequestCreation().createRequest(this);
		}

	}

	public Socket getRequestSocket() {
		return requestSocket;
	}

	public void setRequestSocket(Socket requestSocket) {
		this.requestSocket = requestSocket;
	}

	public BufferedReader getReader() {
		return reader;
	}

	public void setReader(BufferedReader reader) {
		this.reader = reader;
	}

	public PrintWriter getWriter() {
		return writer;
	}

	public void setWriter(PrintWriter writer) {
		this.writer = writer;
	}

	public DataInputStream getDataReader() {
		return dataReader;
	}

	public void setDataReader(DataInputStream dataReader) {
		this.dataReader = dataReader;
	}

	public DataOutputStream getDataWriter() {
		return dataWriter;
	}

	public void setDataWriter(DataOutputStream dataWriter) {
		this.dataWriter = dataWriter;
	}

	public ArrayList<String> getGameList() {
		return gameList;
	}

	public void setGameList(ArrayList<String> gameList) {
		this.gameList = gameList;
	}

	public boolean gotTheGame(String game) {
		for (String s : this.gameList) {
			if (game.equals(s))
				return true;
		}
		return false;
	}

	public String listTheGame() {
		String list = "";
		for (String s : this.gameList)
			list = list + s + (" - ");

		return list;
	}

}
