import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        int size = 0;

        String user_input = getString("Please enter size of shape: ");
        size = Integer.parseInt(user_input);
        System.out.println(triangle(size, "*"));
        System.out.println(triangleRev(size, "*"));
        System.out.println(diamond(size, "*"));
    }


    private static String getString(String prompt) {
        System.out.print(prompt);
        String user_input = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            user_input = br.readLine();
        } catch (IOException ioe) {
            System.out.println("IO Error trying to read");
            System.exit(1);
        }

        return user_input;
    }

    private static String square(int size, String ch) {
        String square = null;

        square = (multString(size, ch) + "\n");
        for (int i = 2; i < size; i++) {
            square += (ch + multString(size - 2, " ") + ch + "\n");
        }

        square += (multString(size, ch) + "\n");

        return square;
    }

    private static String triangle(int size, String ch) {

        if (size<1){
            return "Enter size greater than 0";
        }

        String triangle = null;
        int space = 0;

        triangle = ch + "\n";
        if (size > 1) {
            for (int i = 2; i < size; i++) {
                triangle += (ch + multString(space, " ") + ch + "\n");
                space++;
            }
            triangle += (multString(size, ch) + "\n");
        }

        return triangle;
    }

    private static String triangleRev(int size, String ch) {

        if (size<1){
            return "Enter size greater than 0";
        }

        String triangle = null;
        int space_in = 0;
        int space_out = size - 1;

        triangle = multString(space_out, " ") + ch + "\n";

        if (size > 1) {
            for (int i = 2; i < size; i++) {
                triangle += (multString(space_out -= 1, " ") + ch + multString(space_in, " ") + ch + "\n");
                space_in++;
            }

            triangle += (multString(size, ch) + "\n");
        }

        return triangle;

    }

    private static String diamond(int size, String ch) {
        if (size<1){
            return "Enter size greater than 0";
        }

        String diamond = null;
        int space_in = 1;
        int space_out = size - 1;

        diamond = multString(size - 1, " ") + ch + "\n";

        if (size > 1) {
            for (int i = 1; i < size; i++) {
                diamond += (multString(space_out -= 1, " ") + ch + multString(space_in, " ") + ch + "\n");
                space_in += 2;
            }
            space_in -= 4;
            for (int i = 2; i < size; i++) {
                diamond += (multString(space_out += 1, " ") + ch + multString(space_in, " ") + ch + "\n");
                space_in -= 2;
            }
        }

        diamond += multString(size - 1, " ") + ch + "\n";

        return diamond;
    }

    private static String multString(int length, String ch) {
        String st = "";
        for (int i = 0; i < length; i++) {
            st += ch;
        }
        return st;
    }
}
