/**
 * Created by Cody on 2/21/2017.
 */
class LineOutput implements Output { //adds newline with every write
    private Output sink;
    public LineOutput(Output s) {
        sink = s;
    }
    public void write (Object o){
        sink.write(o + "\n");
    }
}