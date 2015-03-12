package serverRequest;

import main.java.games.tictactoe.TicTacToeHost;
import serverComponents.ServerRequest;

public class RequestCREATE implements Request
{
	@Override
	public void processRequest(ServerRequest request)
	{	
		
		if (!(request.query[1].isEmpty()))
		{
			switch (request.query[1])
			{
				case ("tictactoe"):
					TicTacToeHost tictactoe = new TicTacToeHost();
					tictactoe.playGame(request);
					break;
					
				/* case("isola"):
					IsolaHost isola = new IsolaHost ();
					isola.playGame();
					break;
					
				case ("potato"):
					HotPotatoHost hotPotato = new HotPotatoHost();
					hotPotato.playGame();
					break;
				*/
					
				default:
					request.writer.println("Unknown game");
					break;
			}
		}
		
		else
		{
			request.writer.println("Bad use of command 'create', use 'create <game>'");
			request.writer.flush();
			return;
		}
		
		return;
	}

}
