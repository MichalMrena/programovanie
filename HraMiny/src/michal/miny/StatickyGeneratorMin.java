package michal.miny;

import java.util.ArrayList;

public class StatickyGeneratorMin implements IGeneratorMin {

    @Override
    public ArrayList<Pozicia> generujMiny(int pocetMin, int pocetRiadkov, int pocetStlpcov) {
        ArrayList<Pozicia> pozicie = new ArrayList<Pozicia>();
        pozicie.add(new Pozicia(1, 1));
        pozicie.add(new Pozicia(2, 3));
        pozicie.add(new Pozicia(3, 0));
        return pozicie;
    }
}
