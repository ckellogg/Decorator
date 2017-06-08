/**
 * Created by Cody on 2/21/2017.
 */
import java.io.IOException;
import java.io.Writer;

class StreamOutput implements Output {
    private Writer sink;
    StreamOutput(Writer stream) {
        sink = stream;
    }

    public void write(Object o) {
        try {
            sink.write(o.toString());
            sink.flush();
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}