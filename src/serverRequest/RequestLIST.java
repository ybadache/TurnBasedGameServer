package serverRequest;

import serverComponents.ServerRequest;

public class RequestLIST implements Request
{

	@Override
	public void processRequest(ServerRequest request)
	{
		request.writer.println(request.listTheGame());
		return;
	}

}
