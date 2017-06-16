/**
 * Created by jocelio.lima on 6/16/2017.
 */
public class Main {

    public static void main(String[] args) {

//        String input ="333277778";
//        String input ="11166611144411";
//        String input ="222 277772";
          String input ="886207777336683366222 20555666 6642";
//        String input = "0123456789";

        final String output = new SMS().getMessage(input);
        System.out.println(output);
    }
}
