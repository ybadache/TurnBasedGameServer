package serverRequest;

import serverComponents.ServerRequest;

public class RequestLEAVE implements Request
{

	@Override
	public void processRequest (ServerRequest request)
	{
		request.writer.println("Game left successfully");
		return;
	}
}
