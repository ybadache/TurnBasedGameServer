package serverRequest;

import serverComponents.ServerRequest;

public class RequestJOIN implements Request
{

	@Override
	public void processRequest(ServerRequest request)
	{
		request.writer.println("Game joined !");
		return;
	}

}
