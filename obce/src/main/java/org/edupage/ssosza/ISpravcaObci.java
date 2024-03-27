package org.edupage.ssosza;

import java.util.List;

public interface ISpravcaObci {
    List<String> getOkresy();
    List<Obec> getObce();
    List<Obec> getObce(String okres);
}
