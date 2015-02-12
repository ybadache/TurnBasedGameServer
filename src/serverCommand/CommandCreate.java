package serverCommand;

import serverComponents.ServerRequest;

public class CommandCreate implements Command {

	private Receiver requestReceiver;
	private ServerRequest sr;
	
	public CommandCreate (Receiver requestReceiver, ServerRequest sr)
	{
		this.requestReceiver = requestReceiver;
		this.sr = sr;
	}
	
	public void execute ()
	{
		requestReceiver.createGame(sr);
	}
}
