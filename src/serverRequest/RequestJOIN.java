package serverRequest;

import serverComponents.ServerRequest;

public class RequestJOIN implements Request
{

	@Override
	public void processRequest(ServerRequest request)
	{
		request.writer.flush();
		request.writer.println("Game joined !");
		request.writer.flush();
		return;
	}

}
