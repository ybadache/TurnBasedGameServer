package serverRequest;
import serverComponents.ServerRequest;

public class RequestCreation {

	public void createRequest (ServerRequest request)
	{
		switch (request.query[0])
		{
			case("list"):
				new RequestLIST().processRequest(request);
				break;
				
			case("create"):
				new RequestCREATE().processRequest(request);
				break;
				
			case("join"):
				new RequestJOIN().processRequest(request);
				break;
				
			case("leave"):
				new RequestLEAVE().processRequest(request);
				break;
				
			case("exit"):
				new RequestEXIT().processRequest(request);
				break;
				
			default:
				new RequestNYI().processRequest(request);
				break;
		}
		
	}
}
