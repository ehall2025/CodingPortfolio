import java.util.Scanner;
import java.util.ArrayList;


public class Controller {
    static Scanner scan = new Scanner(System.in);
    static ConsoleMenu cm;

    ArrayList<ListManager> lists;
    ArrayList<MenuItem> menuItems;
 
    public void init() {
        lists = new ArrayList<ListManager>();
        menuItems = new ArrayList<MenuItem>();
        createCommands();
        
        //Create ConsoleMenu instance
        cm = new ConsoleMenu(menuItems, "String List Menu", scan);
    }

    private void createCommands() {

        //create StringList
        menuItems.add(new MenuItem("Add new String List", () -> {
            return new AddStringListCommand(this);
        }));

        //create NumberList
        menuItems.add(new MenuItem("Add new Number List", () -> {
            return new AddNumberListCommand(this);
        }));

        //exit command
        menuItems.add(new MenuItem("Quit", () -> {
            return new ExitCommand();
        }));
    }

    public void addStringList() {
        lists.add(new StringListManager());
        int newIndex = lists.size() - 1;

        menuItems = new ArrayList<MenuItem>();

        menuItems.add(new MenuItem("Sort List " + (newIndex + 1), () -> {
            return new SortCommand((StringListManager)lists.get(newIndex));
        }));
        menuItems.add(new MenuItem("Clear List " + (newIndex + 1), () -> {
            return new ClearCommand(lists.get(newIndex));
        }));
        menuItems.add(new MenuItem("Print List " + (newIndex + 1), () -> {
            return new PrintCommand(lists.get(newIndex));
        }));
        menuItems.add(new MenuItem("Add String to List " + (newIndex + 1), () -> {
            ArrayList<String> newElements = new ArrayList<String>();
            String input;
            System.out.println("\nEnter words into List " + newIndex + 1 + " one at a time \nEnter the word 'quit' to stop \n");

            System.out.print("Enter word " + (newElements.size() + 1) + ": ");
            input = scan.next();

            while (!input.equals("quit")) {
                newElements.add(input);
                System.out.print("Enter word " + (newElements.size() + 1) + ": ");
                input = scan.next();
            }

            return new AppendCommand(lists.get(newIndex), newElements);
        }));

        cm.addMenuItems(menuItems);
    }

    public void addNumberList() {
        lists.add(new NumberListManager());
        int newIndex = lists.size() - 1;

        menuItems = new ArrayList<MenuItem>();

        menuItems.add(new MenuItem("Clear List " + (newIndex + 1), () -> {
            return new ClearCommand(lists.get(newIndex));
        }));
        menuItems.add(new MenuItem("Print List " + (newIndex + 1), () -> {
            return new PrintCommand(lists.get(newIndex));
        }));
        menuItems.add(new MenuItem("Add Numbers to List " + (newIndex + 1), () -> {
            ArrayList<String> newElements = new ArrayList<String>();
            String input;
            System.out.println("\nEnter words into List " + (newIndex + 1) + " one at a time \nEnter the word 'quit' to stop \n");

            System.out.print("Enter word " + (newElements.size() + 1) + ": ");
            input = scan.next();

            while (!input.equals("quit")) {
                try {
                    Double.parseDouble(input);
                    newElements.add(input);
                } catch(NumberFormatException e) {
                    System.err.println("Please enter a number");
                }
                
                System.out.print("Enter word " + (newElements.size() + 1) + ": ");
                input = scan.next();
            }

            return new AppendCommand(lists.get(newIndex), newElements);
        }));
        menuItems.add(new MenuItem("Get largest number in list " + (newIndex + 1), () -> {
            return new GetLargestCommand((NumberListManager)lists.get(newIndex));
        }));

        cm.addMenuItems(menuItems);
    }

    public static void main(String[] args) throws Exception {
        Controller myController = new Controller();
        myController.init();

        //run program
        cm.run();
    }
}
