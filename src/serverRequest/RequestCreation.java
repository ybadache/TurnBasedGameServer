package serverRequest;
import serverComponents.ServerRequest;

public class RequestCreation {

	public void createRequest (ServerRequest request)
	{
		switch (request.query[0])
		{
			case("list"):
				new RequestLIST().processRequest(request);
			System.out.println ("list request");
				break;
				
			case("create"):
				new RequestCREATE().processRequest(request);
			System.out.println ("create request");
				break;
				
			case("join"):
				new RequestJOIN().processRequest(request);
			System.out.println ("join request");
				break;
				
			case("leave"):
				new RequestLEAVE().processRequest(request);
			System.out.println ("leave request");
				break;
				
			case("exit"):
				new RequestEXIT().processRequest(request);
			System.out.println ("exit request");
				break;
				
			default:
				new RequestNYI().processRequest(request);
				System.out.println ("nyi request");
				break;
		}
		
	}
}
