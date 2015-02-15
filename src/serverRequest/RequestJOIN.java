package serverRequest;

import serverComponents.ServerRequest;

public class RequestJOIN implements Request
{

	@Override
	public void processRequest(String[] query, ServerRequest request)
	{
		if (!(query[0].equals("JOIN")))
		{
			this.successor(query, request);
			return;
		}
	
		System.out.println("Game joined !");
	}

	@Override
	public void successor(String[] query, ServerRequest request)
	{
		new RequestLEAVE().processRequest (query, request);
	}

}
