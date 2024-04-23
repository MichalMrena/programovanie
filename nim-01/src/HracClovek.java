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
            String vstup = sc.nextLine();
            try {
                int cislo = Integer.parseInt(vstup);
                if (cislo == 1 || cislo == 2) {
                    pocet = cislo;
                } else {
                    System.out.println("Zadaj 1 alebo 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Neplatny vstup, zadaj cislo!");
            }
        } while (pocet == -1);
        hra.odstranZapalky(pocet);
    }
}
