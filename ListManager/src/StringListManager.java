import java.util.ArrayList;
import java.util.Collections;

/**
 * String List Mangaer allows the user to create and add string to a list as well as
 * interact with the list in the following ways:
 *  sort the list
 *  append new strings to the list
 *  print the list
 *  clear the list
 */
public class StringListManager extends ListManager {

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

    public void sort () {
        Collections.sort(ary);
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