import java.util.Random;

public class Main {

    public static Hrac vytvorHraca() {
        Random r = new Random();
        if (r.nextBoolean()) {
            return new HracClovek("Jack");
        } else {
            return new HracPocitac();
        }
    }

    // vypis#int
    public static void vypis(int x) {
        System.out.format("Vypisane cislo: %d%n", x);
    }

    // vypis#String
    public static void vypis(String text) {
        System.out.format("Vypisany text \"%s\"", text);
    }

    public static void main(String[] args) {
//        Hrac h = vytvorHraca();
//        h.zober(null);

        vypis(10);      // -> call vypis#int
        vypis("Foo"); // -> call vypis#String
    }
}
