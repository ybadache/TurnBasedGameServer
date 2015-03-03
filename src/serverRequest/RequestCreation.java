package serverRequest;
import serverComponents.ServerRequest;

public class RequestCreation {

	public void createRequest (ServerRequest request)
	{
		System.out.println (request.query[0]);
		
		switch (request.query[0])
		{
			case("list"):
				System.out.println ("list request");
				new RequestLIST().processRequest(request);			
				break;
				
			case("create"):
				System.out.println ("create request");
				new RequestCREATE().processRequest(request);			
				break;
				
			case("join"):
				System.out.println ("join request");
				new RequestJOIN().processRequest(request);
				break;
				
			case("leave"):
				System.out.println ("leave request");
				new RequestLEAVE().processRequest(request);
				break;
				
			case("exit"):
				System.out.println ("exit request");
				new RequestEXIT().processRequest(request);
				break;
				
			default:
				System.out.println ("nyi request");
				new RequestNYI().processRequest(request);
				break;
		}
		
	}
}
