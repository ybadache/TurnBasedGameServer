package serverCommand;

import serverComponents.ServerRequest;

public class CommandList implements Command {

	private Receiver requestReceiver;
	private ServerRequest sr;
	
	public CommandList (Receiver requestReceiver, ServerRequest sr)
	{
		this.requestReceiver = requestReceiver;
		this.sr = sr;
	}
	
	public void execute ()
	{
		requestReceiver.listGame(sr);
	}
}
