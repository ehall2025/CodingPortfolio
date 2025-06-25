

public class ClearCommand implements Commandable {
	
	private ListManager list;

	public ClearCommand(ListManager list) {
		this.list = list;
	}
	
	@Override
	public String execute() {
		list.clear();
		return "List is now cleared";
	}
}