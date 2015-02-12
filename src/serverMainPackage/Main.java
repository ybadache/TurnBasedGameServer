package serverMainPackage;

import serverComponents.Server;

public class Main {
	
	public static void main (String args[])
	{
		Server server = new Server ();
		server.init(2121);
		server.run();
	}
	
}
