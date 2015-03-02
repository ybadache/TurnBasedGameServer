package serverRequest;

import serverComponents.ServerRequest;

public class RequestNYI implements Request {
	@Override
	public void processRequest(ServerRequest request)
	{	
		request.writer.println("Not yet implemented !");
		return;
	}

}
