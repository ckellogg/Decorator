/**
 * Created by Cody on 2/22/2017.
 */
public class NoDigit implements Predicate{

    @Override
    public boolean execute(Object o) {
        if (o.toString().matches("[^0-9]*")) { //"[^0-9]*[12]?[0-9]{1,2}[^0-9]*")
            // System.out.print("true ");
            return true;
        }
        return false;
    }
}


