/**
 * Created by Cody on 2/21/2017.
 */
public class IsDigit implements Predicate{

   @Override
    public boolean execute(Object o) {
        if (!o.toString().matches("[^0-9]*")) { //"[^0-9]*[12]?[0-9]{1,2}[^0-9]*")
           // System.out.print("true ");
            return true;
        }
        return false;
    }
}