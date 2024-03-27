package org.edupage.ssosza;

import java.util.ArrayList;
import java.util.List;

public class DummySpravcaObci implements ISpravcaObci {
    @Override
    public List<String> getOkresy() {
        return List.of(new String[]{"foo", "boo", "moo"});
    }

    @Override
    public List<Obec> getObce() {
        return null;
    }

    @Override
    public List<Obec> getObce(String okres) {
        return null;
    }
}
