import java.util.ArrayList;
import java.util.List;

public class HraNim {
    private int pocetZapaliek;
    private StavHry stav;
    private final List<Hrac> hraci;
    private int hracNaTahu;

    public HraNim() {
        this.pocetZapaliek = 10;
        this.stav = StavHry.NEZACALA;
        this.hraci = new ArrayList<>();
        this.hracNaTahu = 0;
    }

    public int getPocetZapaliek() {
        return this.pocetZapaliek;
    }

    public StavHry getStavHry() {
        return this.stav;
    }

    public void pridajHraca(Hrac hrac) {
        if (this.hraci.size() >= 2) {
            throw new RuntimeException("Too many players!");
        }
        this.hraci.add(hrac);
    }

    public void odstranZapalky(int pocet) {
        if (pocet != 1 && pocet != 2) {
            throw new RuntimeException("Invalid match count!");
        }

        int novyPocet = this.pocetZapaliek - pocet;
        if (novyPocet < 0) {
            throw new RuntimeException("Not enough matches!");
        }

        this.pocetZapaliek = novyPocet;
    }

    public void spustiHru() {
        this.stav = StavHry.PREBIEHA;
        this.vypisStav();
        while (this.stav == StavHry.PREBIEHA) {
            this.hraci.get(this.hracNaTahu).zober(this);
            this.vypisStav();
            if (this.pocetZapaliek == 0) {
                this.stav = StavHry.UKONCENA;
                break;
            }
            this.hracNaTahu++;
            this.hracNaTahu %= 2;
        }
    }

    public Hrac getVitaz() {
        if (this.stav != StavHry.UKONCENA) {
            throw new RuntimeException("Game not finished yet!");
        }
        return this.hraci.get(this.hracNaTahu);
    }

    private void vypisStav() {
        System.out.println("|".repeat(this.pocetZapaliek));
    }
}
