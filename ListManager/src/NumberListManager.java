import java.util.ArrayList;
/**
 * String List Mangaer allows the user to create and add string to a list as well as
 * interact with the list in the following ways:
 *  sort the list
 *  append new strings to the list
 *  print the list
 *  clear the list
 */
public class NumberListManager extends ListManager {

    /**
     * ary stores the lists of words the user inputs
     */
    private ArrayList<String> ary = new ArrayList<String>();

    public void append (ArrayList<String> newElements) {
        ary.addAll(newElements);
    }

    public void clear () {
        ary = new ArrayList<String>();
    }

    public String getLargest() {
        if (ary.size() == 0) return "The list is empty";
        String largest = ary.get(0);
        for (String num: ary) {
            if (Double.parseDouble(largest) < Double.parseDouble(num)) largest = num;
        }

        return largest;
    }

    @Override
    public String toString() {
        String ret = "";

        ret += "\n{";
        for (String print: ary) {
            if (ary.get(0) != print) ret += ", ";
            ret += print;
        }

        ret += "}";

        return ret;
    }
}