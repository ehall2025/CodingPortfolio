
public class AddStringListCommand implements Commandable {
    
    private Controller myController;

    public AddStringListCommand(Controller myController) {
        this.myController = myController;
    }

    @Override
    public String execute() {
        myController.addStringList();
        return "";
    }
}