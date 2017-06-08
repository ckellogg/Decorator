/**
 * Created by Cody on 2/21/2017.
 */
import java.io.*;
import java.util.Scanner;

public class decor {
    public static void main(String[] args) {

        String line = null;
        String fileName = null;
        String addDecor = null;
       // File outputFile =new File("output.dat");

        try{
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a file name: ");
            System.out.flush();
            fileName = scanner.nextLine();
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);
            Output stream = new StreamOutput(new PrintWriter(System.out));
            Scanner scan = new Scanner(System.in);

            printMenu();
            addDecor = scan.nextLine();

            while(!addDecor.equals("done")){
                //printMenu();
                switch(addDecor){
                    case "line":
                        stream = new LineOutput(stream);
                        break;
                    case "enum":
                        stream = new EnumeratedOutput(stream);
                        break;
                    case "tee":
//                        System.out.flush();
                        System.out.print("New file name: ");
                        String newFile = null;
                        newFile= scanner.nextLine();
                        stream = new TeeOutput(stream, newFile);
                        break;
                    case "filter":
                        String addFilter = null;
                        printFilter();
                        addFilter = scan.nextLine();

                        switch(addFilter) {
                            case "digit":
                                    stream =new FilterOutput(stream, new IsDigit());
                                break;
                            case "no#":
                             stream = new FilterOutput(stream, new NoDigit());
                                break;
                            default:
                                System.out.print("Invalid Filter, None added");
                                printMenu();
                        }
                        break;
                    case "done":
                        System.out.print("Printing your output...  \n");
                        break;
                    case "star":
                        stream = new StarWave(stream);
                        break;
                    case "star2":
                        stream = new StarDiamond(stream);
                        break;
                    default:
                        System.out.print("Invalid input, try again! \n");
                        break;
                }
                addDecor = scan.nextLine();
            }
            // FileReader reads text files in the default encoding.
            // FileReader fileReader =new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
               // System.out.println(line);
                stream.write(line);
            }
            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
        }
    }

    private static void printMenu() {
        System.out.print("\nWhat decorators would you like to add: \n\n");
        System.out.print("line      :to add a newline to every line. \n");
        System.out.print("enum      :to add a newline and number the lines. \n");
        System.out.print("tee       :writes to a new file (you'll be ask for it. \n");
        System.out.print("filter    :writes only those objects that satisfy a certain condition. \n");
        System.out.print("star      :Fancy Decorator with waves of stars (*). \n");
        System.out.print("star2     :Fancy Decorator with diamonds of stars (*). \n");
        System.out.print("done      :when you finished adding decorators. \n\n");
    }
    private static void printFilter(){
        System.out.print("\nWhat filter would you like: \n");
        System.out.print("\tdigit      :Has Digit in line. \n");
        System.out.print("\tno#      :No numbers in the line\n");
    }
}


