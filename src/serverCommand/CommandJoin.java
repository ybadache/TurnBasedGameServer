package serverCommand;

import serverComponents.ServerRequest;

public class CommandJoin implements Command {

	private Receiver requestReceiver;
	private ServerRequest sr;
	
	public CommandJoin (Receiver requestReceiver, ServerRequest sr)
	{
		this.requestReceiver = requestReceiver;
		this.sr = sr;
	}
	
	public void execute ()
	{
		requestReceiver.joinGame(sr);
	}
}
