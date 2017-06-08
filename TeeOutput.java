/**
 * Created by Cody on 2/21/2017.
 */
import java.io.*;
class TeeOutput implements Output {  //writes to two streams at a time;
    // the one it wraps, plus one it receives as a constructor argument
    private Output sink;
    private Output newStream;
    File newFile;

//    PrintWriter printWriter = null;
    public TeeOutput(Output stream, String newFileName) {
        sink = stream;

        try {
            newFile = new File(newFileName);
            newStream = new StreamOutput(new PrintWriter(newFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void write (Object o) {
        sink.write(o);
        newStream.write(o);
    }
}


