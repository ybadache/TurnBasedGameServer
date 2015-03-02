package serverRequest;

import serverComponents.ServerRequest;

public class RequestEXIT implements Request
{

	@Override
	public void processRequest(ServerRequest request)
	{
		try {
			request.requestSocket.close();
			request.dataWriter.close();
			request.dataWriter.close();
			
		} catch (Exception e) {
			e.printStackTrace();	
		}
		
		request.writer.println("Exit !");
		return;
	}
}
