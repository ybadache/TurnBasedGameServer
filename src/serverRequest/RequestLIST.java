package serverRequest;

import serverComponents.ServerRequest;

public class RequestLIST implements Request
{

	@Override
	public void processRequest(String[] query, ServerRequest request)
	{
		if (!(query[0].equals("USER")))
		{
			this.successor(query, request);
			return;
		}
		
		request.listTheGame();	
	}

	@Override
	public void successor(String[] query, ServerRequest request)
	{
		new RequestCREATE().processRequest(query, request);
	}

}
