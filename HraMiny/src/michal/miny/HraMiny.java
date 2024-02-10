package michal.miny;

import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Toto je hracia plocha.
 */
public class HraMiny {

    private Policko[][] policka;

    private StavHry stavHry;

    private int pocetZostavajucich;

    public HraMiny(int pocetRiadkov, int pocetStlpcov, List<Pozicia> miny) {

        this.policka = new Policko[pocetRiadkov][pocetStlpcov];
        this.stavHry = StavHry.PREBIEHA;
        this.pocetZostavajucich = pocetRiadkov * pocetStlpcov - miny.size();

        for (int riadok = 0; riadok < pocetRiadkov; riadok++) {
            for (int stlpec = 0; stlpec < pocetStlpcov; stlpec++) {
                boolean jeTamMina = this.obsahujeMinu(miny, riadok, stlpec);
                int pocetMinVOkoli = this.spocitajMinyVOkoli(miny, riadok, stlpec);
                this.policka[riadok][stlpec] = new Policko(jeTamMina, pocetMinVOkoli);
            }
        }
    }

    public IPopisPolicka getPolicko(int riadok, int stlpec) {
        return this.policka[riadok][stlpec];
    }

    public int getPocetRiadkov() {
        return this.policka.length;
    }

    public int getPocetStlpcov() {
        return this.policka[0].length;
    }

    public StavHry getStavHry() {
        return this.stavHry;
    }

    public void odkry(int riadok, int stlpec) {
        if (!this.jeVHracejPloche(riadok, stlpec)) {
            return;
        }

        if (this.stavHry != StavHry.PREBIEHA) {
            return;
        }

        Policko policko = this.policka[riadok][stlpec];
        if (policko.jeOdkryte() || policko.jeOznacene()) {
            return;
        }

        if (policko.obsahujeMinu()) {
            this.stavHry = StavHry.PREHRA;
            return;
        }

        this.odkryOkolie(riadok, stlpec);

        if (this.pocetZostavajucich == 0) {
            this.stavHry = StavHry.VYHRA;
        }
    }

    public void oznac(int riadok, int stlpec) {
        if (this.stavHry != StavHry.PREBIEHA) {
            return;
        }

        this.policka[riadok][stlpec].oznac();
    }

    public void odznac(int riadok, int stlpec) {
        if (this.stavHry != StavHry.PREBIEHA) {
            return;
        }

        this.policka[riadok][stlpec].odznac();
    }

    public void ukonci() {
        this.stavHry = StavHry.UKONCENA;
    }

    private void odkryOkolie(int riadok, int stlpec) {
        ArrayList<Pozicia> pozicie = new ArrayList<Pozicia>();
        pozicie.add(new Pozicia(riadok, stlpec));

        while (!pozicie.isEmpty()) {
            // vyber poslednu poziciu a policko na danej pozicii
            int index = pozicie.size() - 1;
            Pozicia pozicia = pozicie.get(index);
            pozicie.remove(index);
            Policko policko = this.policka[pozicia.getRiadok()][pozicia.getStlpec()];

            //assert(!policko.jeOdkryte());

            policko.odkry();
            this.pocetZostavajucich--;

            if (policko.getPocetMinVOkoli() > 0) {
                continue;
            }

            for (int dr = -1; dr < 2; dr++) {
                for (int ds = -1; ds < 2; ds++) {
                    if (dr == 0 && ds == 0) {
                        continue;
                    }

                    int susednyRiadok = pozicia.getRiadok() + dr;
                    int susednyStlpec = pozicia.getStlpec() + ds;

                    if (!this.jeVHracejPloche(susednyRiadok, susednyStlpec)) {
                        continue;
                    }

                    Policko susedne = this.policka[susednyRiadok][susednyStlpec];
                    if (!susedne.obsahujeMinu() && !susedne.jeOdkryte()) {
                        pozicie.add(new Pozicia(susednyRiadok, susednyStlpec));
                    }
                }
            }
        }
    }

    public void debugPrint() {
        for (Policko[] riadok : this.policka) {
            for (Policko policko : riadok) {
                if (policko.obsahujeMinu()) {
                    System.out.print("x");
                } else if (policko.getPocetMinVOkoli() > 0) {
                    System.out.print(policko.getPocetMinVOkoli());
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private int spocitajMinyVOkoli(List<Pozicia> miny, int riadok, int stlpec) {
        int pocet = 0;

        for (int dr = -1; dr < 2; dr++) {
            for (int ds = -1; ds < 2; ds++) {
                if (dr == 0 && ds == 0) {
                    continue;
                }

                int kontrolovanyRiadok = riadok + dr;
                int kontrolovanyStlpec = stlpec + ds;

                if (!this.jeVHracejPloche(kontrolovanyRiadok, kontrolovanyStlpec)) {
                    continue;
                }

                if (this.obsahujeMinu(miny, kontrolovanyRiadok, kontrolovanyStlpec)) {
                    pocet++;
                }
            }
        }

        return pocet;
    }

    private boolean jeVHracejPloche(int kontrolovanyRiadok, int kontrolovanyStlpec) {
        return kontrolovanyRiadok >= 0 &&
               kontrolovanyStlpec >= 0 &&
               kontrolovanyRiadok < this.getPocetRiadkov() &&
               kontrolovanyStlpec < this.getPocetStlpcov();
    }

    private boolean obsahujeMinu(List<Pozicia> miny, int riadok, int stlpec) {
        for (Pozicia pozicia : miny) {
            if (pozicia.jeRovnaka(riadok, stlpec)) {
                return true;
            }
        }
        return false;
    }

}










