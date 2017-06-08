/**
 * Created by Cody on 2/21/2017.
 */
public class FilterOutput implements Output{
   private Output filteredOutput;
    private Predicate p;

    public FilterOutput(Output filteredOutput, Predicate p) {
        this.filteredOutput = filteredOutput;
        this.p = p;
    }

    public void write(Object o) {
        if (p.execute(o)){
            filteredOutput.write(o.toString());
        }
    }
}
