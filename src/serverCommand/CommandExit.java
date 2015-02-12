package serverCommand;

import serverComponents.ServerRequest;

	public class CommandExit implements Command {
		
	private Receiver requestReceiver;
	private ServerRequest sr;
	
	public CommandExit (Receiver requestReceiver, ServerRequest sr)
	{
		this.requestReceiver = requestReceiver;
		this.sr = sr;
	}
	
	public void execute ()
	{
		requestReceiver.exitServer(sr);
	}
}
