package serverComponents;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server extends Thread
{
	public Socket socket;
	public ServerSocket servSocket;
	
	/**
	 * Initialization of the server socket's port.
	 * @param port Port number on which we will connect
	 */
	public void init (int port)
	{
		try
		{
			this.servSocket = new ServerSocket (port);
			System.out.println("Socket succesfully launched at port " + port);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void run ()
	{
		while (true)
		{
			System.out.println ("Waiting for client ...");
			try
			{
				this.socket = this.servSocket.accept();
				new Thread (new ServerRequest(this.socket)).run();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
	}

	public Socket getSocket () {
		return socket;
	}	

	public void setSocket (Socket socket) {
		this.socket = socket;
	}

	public ServerSocket getServSocket () {
		return servSocket;
	}

	public void setServSocket (ServerSocket servSocket) {
		this.servSocket = servSocket;
	}
}
