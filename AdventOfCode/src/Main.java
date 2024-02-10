import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<String> readInput() throws FileNotFoundException {
        File f = new File("input.txt");
        if (!f.exists()) {
            System.out.println("not good");
            return null;
        }

        ArrayList<String> input = new ArrayList<>();
        Scanner sc = new Scanner(f);
        while (sc.hasNextLine()) {
            input.add(sc.nextLine());
        }
        return input;
    }

    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private static int calculateStrValue(String str) {
        int prve = 0;
        int druhe = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                prve = c - '0';
                break;
            }
        }

        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                druhe = c - '0';
                break;
            }
        }

        return 10 * prve + druhe;
    }

    public static void main(String[] args) throws FileNotFoundException {
        var input = readInput();
        if (input == null) {
            System.out.println("not good");
            return;
        }
        int result = 0;
        for (String str : input) {
            result += calculateStrValue(str);
        }
        System.out.println(result);
    }
}