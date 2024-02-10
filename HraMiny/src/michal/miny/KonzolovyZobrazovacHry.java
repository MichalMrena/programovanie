package michal.miny;

public class KonzolovyZobrazovacHry {

    void zobraz(HraMiny hra) {
        for (int riadok = 0; riadok < hra.getPocetRiadkov(); riadok++) {
            for (int stlpec = 0; stlpec < hra.getPocetStlpcov(); stlpec++) {
                IPopisPolicka policko = hra.getPolicko(riadok, stlpec);
                // # - nie je odkryre
                // f - oznacene
                // 1 - resp. ine cislo ak obsahuje miny v okoli
                // 0 - ak je prazdne a nema miny v okoli
                // x - ak ma minu

                if (policko.jeOznacene()) {
                    System.out.print("f");
                } else if (!policko.jeOdkryte()) {
                    System.out.print("#");
                } else if (policko.obsahujeMinu()) {
                    System.out.print("x");
                } else if (policko.getPocetMinVOkoli() > 0) {
                    System.out.print(policko.getPocetMinVOkoli());
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

}
