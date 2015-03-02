package serverComponents;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import serverRequest.RequestCreation;


public class ServerRequest implements Runnable {
	public Socket requestSocket;
	private Socket dataSocket;
	public BufferedReader reader;
	public PrintWriter writer;
	public DataInputStream dataReader;
	public DataOutputStream dataWriter;
	private ArrayList<String> gameList;
	public String query[];
	

	public ServerRequest (Socket socket)
	{
		this.requestSocket = socket;
		this.gameList = new ArrayList<String>();
		try
		{
			this.reader = new BufferedReader (new InputStreamReader (this.requestSocket.getInputStream()));
			this.writer = new PrintWriter (new OutputStreamWriter (this.requestSocket.getOutputStream()), true);
			this.writer.println ("[SERVER] Game service ready !");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	

	public void initGameList ()
	{	
		this.gameList.add("Patate_chaude");
		this.gameList.add("Isola");
		this.gameList.add("Morpion");
	}
	
	
	public void run ()
	{
		try
		{
			this.initGameList();
			
			this.processRequest();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			this.requestSocket.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void processRequest ()  throws IOException
	{
		String input;
		while ((input = reader.readLine()) != "exit")
		{
			this.query = input.split("//s");
			new RequestCreation().createRequest(this);
		}

	}
	public Socket getRequestSocket() {
		return requestSocket;
	}

	public void setRequestSocket(Socket requestSocket) {
		this.requestSocket = requestSocket;
	}

	public Socket getDataSocket() {
		return dataSocket;
	}

	public void setDataSocket(Socket dataSocket) {
		this.dataSocket = dataSocket;
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
	
	public boolean gotTheGame (String game)	{
		for (String s : this.gameList)	{
			if (game.equals(s))
				return true;
		}
		return false;
	}
	
	public String listTheGame ()	{
		String list = null;
		for (String s : this.gameList)
			list = list + s + ("\n");
		
		return list;
	}
	
	
}
