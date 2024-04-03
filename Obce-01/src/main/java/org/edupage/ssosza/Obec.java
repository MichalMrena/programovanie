package org.edupage.ssosza;

import java.util.Collections;
import java.util.List;

public class Obec {
    private final String nazov;
    private final String okres;
    private final List<Integer> populacia;

    @Override
    public String toString() {
        return "Obec{" +
                "nazov='" + nazov + '\'' +
                ", okres='" + okres + '\'' +
                ", populacia=" + populacia +
                '}';
    }

    public Obec(String nazov, String okres, List<Integer> populacia) {
        this.nazov = nazov;
        this.okres = okres;
        this.populacia = populacia;
    }

    public String getNazov() {
        return this.nazov;
    }

    public String getOkres() {
        return this.okres;
    }

    public List<Integer> getPopulacia() {
        return Collections.unmodifiableList(this.populacia);
    }
}
