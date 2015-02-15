package serverRequest;

import serverComponents.ServerRequest;

public class RequestCREATE implements Request
{

	@Override
	public void processRequest(String[] query, ServerRequest request)
	{
		if (!(query[0].equals("CREATE")))
		{
			this.successor(query, request);
			return;
		}
		
		System.out.println("Game created !");
	}

	@Override
	public void successor(String[] query, ServerRequest request)
	{
		new RequestJOIN().processRequest(query, request);
	}

}
