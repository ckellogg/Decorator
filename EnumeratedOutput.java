/**
 * Created by Cody on 2/21/2017.
 */
class EnumeratedOutput implements Output {     //adds newlines, but precedes each write with the current line number (
private Output sink;
int count = 0;
    public EnumeratedOutput(Output stream) {
        sink = stream;
    }                                   // 1-based) right-justified in a field of width 5, followed by a colon and a space
    public void write (Object o){
        String fixindent= String.format("%5d: ",count++);
        sink.write(fixindent + o + "\n");
    }

}
