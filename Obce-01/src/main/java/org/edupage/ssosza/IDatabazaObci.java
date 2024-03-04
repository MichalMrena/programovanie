package org.edupage.ssosza;

import java.util.List;

public interface IDatabazaObci {
    List<Obec> getObce();
    List<Obec> getObce(String okres);
    List<String> getOkresy();
}
