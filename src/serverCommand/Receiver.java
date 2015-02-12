package serverCommand;

import java.io.IOException;

import serverComponents.ServerRequest;


public class Receiver {
		
	public void listGame (ServerRequest sr)
	{
		int i = 1;
		for (String s : sr.getGameList())
		{
			/* sr.writer*/ System.out.println(i + ") " + s);
			i++;
		}
	}
	
	public void createGame (ServerRequest sr)
	{
		System.out.println("Game created !");
		// sr.writer.println("Game created !");
	}
	
	
	public void joinGame (ServerRequest sr)
	{
		System.out.println("Game joined !");
		//sr.writer.println ("Game joined !");
	}
	
	
	public void leaveGame (ServerRequest sr)
	{
		System.out.println("Game left !");
		//sr.writer.println("Game left sucessfully !");
	}
	
	public void exitServer (ServerRequest sr)
	{
		System.out.println("Socket getting closed ...");
		try
		{
			/* sr.reader.close();
			sr.writer.close();
			*/
			sr.dataReader.close();
			
			sr.requestSocket.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("Socket closed");
	}
	
	
	
}
