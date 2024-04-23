import java.util.Random;

public class Main {

    public static void vypis(double cislo) {
        System.out.format("Vypis cisla: %f%n", cislo);
    }

    public static void vypis(String text) {
        System.out.format("Vypis retazca \"%s\"%n", text);
    }

    public static Hrac vytvorHraca() {
        Random r = new Random();
        boolean coin = r.nextBoolean();
        if (coin) return new HracPocitac();
        else return new HracClovek("Larry");
    }

    public static void main(String[] args) {
//        Hrac h = new HracClovek("Larry");
//        Hrac h = vytvorHraca();
//        h.zober(null);

        vypis(3.14);
        vypis("foo");

        System.out.println(StavHry.NEZACALA.getNazov());
    }
}
