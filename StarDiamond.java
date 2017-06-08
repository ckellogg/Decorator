/**
 * Created by Cody on 2/23/2017.
 */
public class StarDiamond implements Output{
    private Output sink;
    public StarDiamond(Output s) {
        sink = s;
    }

    int count = 1;
    int direction = 0;

    String star;

    public void write (Object o){
        if (direction == 0) {
            switch (count % 3) {
                case 0:
                    star = "*   *";
                    count++;
                    direction = 1;
                    break;
                case 1:
                    star = "  *  ";
                    count++;
                    break;
                case 2:
                    star = " * * ";
                    count++;
                    break;
            }
        }
        else{
            switch (count % 3) {
                case 0:
                    star = "  *  ";
                    count++;
                    direction = 0;
                    break;
                case 1:
                    star = "*   *";
                    count++;
                    break;
                case 2:
                    star = " * * ";
                    count++;
                    break;
            }
        }
        sink.write(star + " " + o + "\n");
    }
}

