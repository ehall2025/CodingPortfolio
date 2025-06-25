
public class AddNumberListCommand implements Commandable {
    
    private Controller myController;

    public AddNumberListCommand(Controller myController) {
        this.myController = myController;
    }

    @Override
    public String execute() {
        myController.addNumberList();
        return "";
    }
}