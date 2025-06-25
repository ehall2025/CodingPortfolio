import java.util.concurrent.Callable;

public class MenuItem {
    String text;
    Callable<Commandable> command;

    public MenuItem(String text, Callable<Commandable> command) {
        setText(text);
        this.command = command;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Commandable generateCommand() throws Exception {
        return command.call();
    }
}
