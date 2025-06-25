

public class GetLargestCommand implements Commandable {
	
	private NumberListManager list;

	public GetLargestCommand(NumberListManager list) {
		this.list = list;
	}
	
	@Override
	public String execute() {
		return list.getLargest();
	}
}

