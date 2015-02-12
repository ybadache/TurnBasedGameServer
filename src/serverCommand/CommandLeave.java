package serverCommand;

import serverComponents.ServerRequest;

public class CommandLeave implements Command {

	private Receiver requestReceiver;
	private ServerRequest sr;
	
	public CommandLeave (Receiver requestReceiver, ServerRequest sr)
	{
		this.requestReceiver = requestReceiver;
		this.sr = sr;
	}
	
	public void execute ()
	{
		requestReceiver.leaveGame(sr);
	}
}
