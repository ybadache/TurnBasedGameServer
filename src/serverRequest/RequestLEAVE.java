package serverRequest;

import serverComponents.ServerRequest;

public class RequestLEAVE implements Request
{

	@Override
	public void processRequest (String[] query, ServerRequest request)
	{
		if (!(query[0].equals("LEAVE")))
		{
			this.successor(query, request);
			return;
		}
	
		System.out.println("Game left successfully");
	}

	@Override
	public void successor(String[] query, ServerRequest request)
	{
		new RequestEXIT().processRequest(query, request);
	}
}
