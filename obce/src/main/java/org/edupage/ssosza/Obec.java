package org.edupage.ssosza;

import java.util.List;
import java.util.TreeMap;

public class Obec {
    private final String nazov;
    private final String okres;
    private final List<ZaznamOPopulacii> obyvatelstvo;

    public Obec(String nazov, String okres, List<ZaznamOPopulacii> obyvatelstvo) {
        this.nazov = nazov;
        this.okres = okres;
        this.obyvatelstvo = obyvatelstvo;
    }

    public String getNazov() {
        return this.nazov;
    }

    public String getOkres() {
        return this.okres;
    }

    public int getAktualnaPopulacia() {
        return this.obyvatelstvo.get(this.obyvatelstvo.size() - 1).getPopulacia();
    }
}
