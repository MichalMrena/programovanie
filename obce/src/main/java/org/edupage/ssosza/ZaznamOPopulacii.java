package org.edupage.ssosza;

public class ZaznamOPopulacii {
    private final int rok;
    private final int populacia;

    public ZaznamOPopulacii(int rok, int populacia) {
        this.rok = rok;
        this.populacia = populacia;
    }

    public int getRok() {
        return this.rok;
    }

    public int getPopulacia() {
        return this.populacia;
    }
}
