import java.util.ArrayList;

public class PozicovnaVysavacov {

    private final ArrayList<Vysavac> vysavace;

    public PozicovnaVysavacov() {
        this.vysavace = new ArrayList<>();
        this.vysavace.add(new Vysavac("cervena", 200));
        this.vysavace.add(new Vysavac("modry", 50));
    }

    public int getPocetVysavacov() {
        return this.vysavace.size();
    }

    public int getPocetVykonnejsich(int n) {
        int pocet = 0;
        for (Vysavac vysavac : this.vysavace) {
            if (vysavac.getVykon() > n) {
                pocet++;
            }
        }
        return pocet;
    }

    public void vypisInfo() {
        for (Vysavac vysavac : this.vysavace) {
            System.out.format("Vykon = %d; farba = %s%n", vysavac.getVykon(), vysavac.getFarba());
        }
    }
}
