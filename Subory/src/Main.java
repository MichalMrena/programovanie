import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Osoba> nacitajOsoby() {
        List<Osoba> osoby = new ArrayList<>();

        File subor = new File("osoby.txt");
//        if (!subor.canRead()) {
//            System.out.println("Subor sa neda citat!");
//            return null;
//        }

        try {
            Scanner sc = new Scanner(subor);
            int pocet = sc.nextInt();
            for (int i = 0; i < pocet; i++) {
                int id = sc.nextInt();
                String rodneCislo = sc.next();
                String meno = sc.next();
                osoby.add(new Osoba(id, rodneCislo, meno));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Subor sa nepodarilo otvorit!");
            return null;
        } catch (InputMismatchException e) {
            System.out.println("Nespravny format suboru!");
            return null;
        }

        return osoby;
    }

    public static void main(String[] args) {
        List<Osoba> osoby = nacitajOsoby();
        if (osoby != null) {
            for (Osoba o : osoby) {
                System.out.println(o);
            }
        }
    }
}