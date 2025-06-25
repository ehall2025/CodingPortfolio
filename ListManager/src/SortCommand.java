

public class SortCommand implements Commandable {
	
	private StringListManager list;

	public SortCommand(StringListManager list) {
		this.list = list;
	}
	
	@Override
	public String execute() {
		list.sort();
		return "List is now sorted";
	}
}