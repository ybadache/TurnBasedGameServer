package serverRequest;

import serverComponents.ServerRequest;

public interface Request {

	
	public abstract void processRequest (String[] query, ServerRequest request);
	
	
	public abstract void successor (String[] query, ServerRequest request);
}
