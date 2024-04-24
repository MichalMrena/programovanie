import java.util.InputMismatchException;
import java.util.Scanner;

public class HracClovek extends Hrac {
    public HracClovek(String meno) {
        super(meno);
    }

    @Override
    public void zober(HraNim hra) {
        int pocet = -1;
        Scanner sc = new Scanner(System.in);

        do {
            try {
                System.out.format("[%s] Zadaj 1 alebo 2: ", this.getMeno());
                int cislo = sc.nextInt();
                if (cislo == 1 || cislo == 2) {
                    pocet = cislo;
                } else {
                    System.out.println("Zadaj 1 alebo 2!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Zadaj cislo!");
            }
        } while (pocet == -1);

        hra.zoberZapalky(pocet);
    }
}
