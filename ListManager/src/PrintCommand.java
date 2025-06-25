

public class PrintCommand implements Commandable {
	
	private ListManager list;

	public PrintCommand(ListManager list) {
		this.list = list;
	}
	
	@Override
	public String execute() {
		return list.toString();
	}
}

