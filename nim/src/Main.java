
public class Main {
    public static void main(String[] args) {
        HraNim hra = new HraNim();
        hra.pridajHraca(new HracClovek("prvy"));
//        hra.pridajHraca(new HracClovek("druhy"));
        hra.pridajHraca(new HracPocitac());
        hra.spustiHru();
        System.out.format("Vyhral hrac: %s%n", hra.getVitaz().getMeno());
    }
}
