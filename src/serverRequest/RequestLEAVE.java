package serverRequest;

import serverComponents.ServerRequest;

public class RequestLEAVE implements Request
{

	@Override
	public void processRequest (ServerRequest request)
	{
		request.writer.flush();
		request.writer.println("Game left successfully");
		request.writer.flush();
		return;
	}
}
