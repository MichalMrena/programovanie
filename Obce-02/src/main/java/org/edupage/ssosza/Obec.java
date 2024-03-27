package org.edupage.ssosza;

import java.util.Collections;
import java.util.List;

public class Obec {
    private final String okres;
    private final String nazov;
    private final List<Integer> populacia;

    public Obec(String okres, String nazov, List<Integer> populacia) {
        this.okres = okres;
        this.nazov = nazov;
        this.populacia = populacia;
    }

    @Override
    public String toString() {
        return "Obec{" +
                "okres='" + okres + '\'' +
                ", nazov='" + nazov + '\'' +
                ", populacia=" + populacia +
                '}';
    }

    public String getOkres() {
        return this.okres;
    }

    public String getNazov() {
        return this.nazov;
    }

    public List<Integer> getPopulacia() {
        return Collections.unmodifiableList(this.populacia);
    }
}
