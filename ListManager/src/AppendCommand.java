
import java.util.ArrayList;

public class AppendCommand implements Commandable {
	
	private ListManager list;
	private ArrayList<String> newElements;

	/**
	 * 
	 * @param list
	 * @param newElements
	 */
	public AppendCommand(ListManager list, ArrayList<String> newElements) {
		this.list = list;
		this.newElements = newElements;
	}
	
	@Override
	public String execute() {
		list.append(newElements);
		return "";
	}
}
