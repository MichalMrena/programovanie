import java.util.Random;

public class Main {

    public static void main(String[] args) {
        HraNim nim = new HraNim();
        nim.pridajHraca(new HracClovek("prvy"));
        nim.pridajHraca(new HracPocitac());
        nim.spustiHru();
        System.out.format("Vyhral hrac s menom %s%n", nim.getVitaz().getMeno());
    }
}
