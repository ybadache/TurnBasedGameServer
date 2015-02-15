package serverRequest;

import serverComponents.ServerRequest;

public class RequestEXIT implements Request
{

	@Override
	public void processRequest(String[] query, ServerRequest request)
	{
		if (!(query[0].equals("EXIT")))
		{
			this.successor(query, request);
			return;
		}
	
		System.out.println("Exit !");
	}

	@Override
	public void successor(String[] query, ServerRequest request)
	{
		
	}

}
