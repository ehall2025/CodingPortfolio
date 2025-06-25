import java.util.ArrayList;

public class ListManager {

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
