package org.edupage.ssosza;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestovaciaDatabazaObci implements IDatabazaObci {

    private final List<Obec> obce;
    private final List<String> okresy;

    public TestovaciaDatabazaObci() {
        this.obce = new ArrayList<>();
        this.okresy = new ArrayList<>();

        this.obce.add(new Obec("Cimenná", "Bánovce nad Bebravou", List.of(106, 105, 101)));
        this.obce.add(new Obec("Pravotince", "Bánovce nad Bebravou", List.of(359, 355, 345)));
        this.obce.add(new Obec("Kotešová", "Bytča", List.of(2249, 2206, 2112)));
        this.obce.add(new Obec("Hvozdnica", "Bytča", List.of(1228, 1200, 1189)));
        this.obce.add(new Obec("Predmier", "Bytča", List.of(1347, 1348, 1352)));
    }

    @Override
    public List<Obec> getObce() {
        return Collections.unmodifiableList(this.obce);
    }

    @Override
    public List<Obec> getObce(String okres) {
        List<Obec> okresneObce = new ArrayList<>();
        for (Obec obec : this.obce) {
            if (obec.getOkres().equals(okres)) {
                okresneObce.add(obec);
            }
        }
        return okresneObce;
    }

    @Override
    public List<String> getOkresy() {
        return Collections.unmodifiableList(this.okresy);
    }
}
