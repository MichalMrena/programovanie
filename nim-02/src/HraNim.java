import java.util.ArrayList;
import java.util.List;

public class HraNim {
    private int pocetZapaliek;
    private StavHry stav;
    private final List<Hrac> hraci;
    private int indexHracaNaTahu;

    public HraNim() {
        this.pocetZapaliek = 10;
        this.stav = StavHry.NEZACALA;
        this.hraci = new ArrayList<>();
        this.indexHracaNaTahu = 0;
    }

    public int getPocetZapaliek() {
        return this.pocetZapaliek;
    }

    public StavHry getStavHry() {
        return this.stav;
    }

    public void pridajHraca(Hrac hrac) {
        if (this.hraci.size() >= 2) {
            throw new RuntimeException("Too many player!");
        }
        this.hraci.add(hrac);
    }

    public void zoberZapalky(int pocet) {
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
        this.vypisHru();
        while (this.stav == StavHry.PREBIEHA) {
            this.hraci.get(this.indexHracaNaTahu).zober(this);
            this.vypisHru();

            if (this.pocetZapaliek == 0) {
                this.stav = StavHry.SKONCILA;
                break;
            }

            this.indexHracaNaTahu++;
            this.indexHracaNaTahu %= 2;
        }
    }

    public Hrac getVitaz() {
        if (this.stav != StavHry.SKONCILA) {
            throw new RuntimeException("Game not finished yet!");
        }
        return this.hraci.get(this.indexHracaNaTahu);
    }

    private void vypisHru() {
        System.out.println("|".repeat(this.pocetZapaliek));
    }
}
