package serverRequest;

import serverComponents.ServerRequest;

public class RequestCREATE implements Request
{
	@Override
	public void processRequest(ServerRequest request)
	{	
		request.writer.println("Game created !");
		return;
	}

}
