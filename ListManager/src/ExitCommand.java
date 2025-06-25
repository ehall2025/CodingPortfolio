

public class ExitCommand implements Commandable {

    @Override
    public String execute() {
        System.exit(0);
        return "";
    }
}