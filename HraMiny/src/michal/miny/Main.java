package michal.miny;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        IGeneratorMin generatorMin = new NahodnyGeneratorMin();
        List<Pozicia> miny = generatorMin.generujMiny(3, 4, 9);

        Scanner scanner = new Scanner(System.in);
        HraMiny hra = new HraMiny(4, 9, miny);
        KonzolovyZobrazovacHry zobrazovac = new KonzolovyZobrazovacHry();
        ParserPrikazov parser = new ParserPrikazov();
        zobrazovac.zobraz(hra);

        while (hra.getStavHry() == StavHry.PREBIEHA) {
            System.out.print("> ");
            String vstup = scanner.nextLine();

            if (vstup.isBlank()) {
                continue;
            }

            IPrikaz prikaz = parser.parsujPrikaz(vstup);
            if (prikaz != null) {
                prikaz.vykonaj(hra);
                zobrazovac.zobraz(hra);
            } else {
                System.out.println("Nespravny prikaz!");
            }
        }

        if (hra.getStavHry() == StavHry.VYHRA) {
            System.out.println("Vyhral si!");
        } else if (hra.getStavHry() == StavHry.PREHRA) {
            System.out.println("Prehral si!");
        }
    }
}
