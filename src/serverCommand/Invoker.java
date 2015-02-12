package serverCommand;

public class Invoker {

	private Command cmdList;
	private Command cmdCreate;
	private Command cmdJoin;
	private Command cmdLeave;
	private Command cmdExitServ;
	
	public void invokeList	()
	{
		if (cmdList != null)
			cmdList.execute();
	}
	
	public void invokeCreate ()
	{
		if (cmdCreate != null)
			cmdCreate.execute();
	}
	
	public void invokeJoin ()
	{
		if (cmdJoin != null)
			cmdJoin.execute();
	}
	
	public void invokeLeave ()
	{
		if (cmdLeave != null)
			cmdLeave.execute();
	}
	
	public void invokeExitServ ()
	{
		if (cmdExitServ != null)
			cmdExitServ.execute();
	}

	public Command getCmdList() {
		return cmdList;
	}

	public void setCmdList(Command cmdList) {
		this.cmdList = cmdList;
	}

	public Command getCmdCreate() {
		return cmdCreate;
	}

	public void setCmdCreate(Command cmdCreate) {
		this.cmdCreate = cmdCreate;
	}

	public Command getCmdJoin() {
		return cmdJoin;
	}

	public void setCmdJoin(Command cmdJoin) {
		this.cmdJoin = cmdJoin;
	}

	public Command getCmdLeave() {
		return cmdLeave;
	}

	public void setCmdLeave(Command cmdLeave) {
		this.cmdLeave = cmdLeave;
	}

	public Command getCmdExitServ() {
		return cmdExitServ;
	}

	public void setCmdExitServ(Command cmdExitServ) {
		this.cmdExitServ = cmdExitServ;
	}
}
