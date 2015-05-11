package serverRequestTreatment;

import serverComponents.RequestHandler;
	

public interface Request {

	public void processRequest (RequestHandler request);
	
	public void treatError();
	
}
