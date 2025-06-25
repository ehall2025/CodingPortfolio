import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleMenu {
	private ArrayList<MenuItem> menuItems;
    private String title;
    private Scanner scan;

    public ConsoleMenu(ArrayList<MenuItem> menuItems, String title, Scanner scan) {
        this.menuItems = menuItems;
        this.title = title;
        this.scan = scan;
    }

    public void addMenuItems(ArrayList<MenuItem> newItems) {
        MenuItem exitCommand = menuItems.get(menuItems.size() - 1);
        menuItems.remove(menuItems.size() - 1);
        menuItems.addAll(newItems);
        menuItems.add(exitCommand);
    }

    public void run() {
        MenuItem currItem;

        while(true) {
            System.out.println(title + ":");
            for(int i = 0; i < menuItems.size(); i++) {
                System.out.println((i + 1) + ": " + menuItems.get(i).getText());
            }

            while(true) {
                System.out.println("Please pick an option:");

                try {
                    currItem = menuItems.get(Integer.parseInt(scan.nextLine()) - 1);
                    break;
                } catch(NumberFormatException e) {
                    System.err.println("Please enter a number\n");
                } catch(IndexOutOfBoundsException e) {
                    System.err.println("Please enter a valid command\n");
                }
            }
            
            try {
                System.out.println("\n" + currItem.generateCommand().execute() + "\n\n");
            } catch (Exception e) {
                System.out.println("\nthar be problems bud\n" + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}