/**
 * Created by Cody on 2/23/2017.
 */
public class StarWave implements Output{
    private Output sink;
    public StarWave(Output s) {
        sink = s;
    }

    int count = 1;
    int direction = 0;
    String star;

    public void write (Object o){
        if (direction == 0) {
            switch (count % 5) {
                case 0:
                    star = "*****";
                    count++;
                    direction = 1;
                    break;
                case 1:
                    star = "    *";
                    count++;
                    break;
                case 2:
                    star = "   **";
                    count++;
                    break;
                case 3:
                    star = "  ***";
                    count++;
                    break;
                case 4:
                    star = " ****";
                    count++;
                    break;
            }
        }
        else{
            switch (count % 5) {
                case 0:
                    star = "    *";
                    count++;
                    direction = 0;
                    break;
                case 1:
                    star = "*****";
                    count++;
                    break;
                case 2:
                    star = " ****";
                    count++;
                    break;
                case 3:
                    star = "  ***";
                    count++;
                    break;
                case 4:
                    star = "   **";
                    count++;
                    break;
            }
        }
        sink.write(star + " " + o + "\n");
    }
}


