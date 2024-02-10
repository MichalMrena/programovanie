package michal.miny;

import java.util.ArrayList;
import java.util.Random;

public class NahodnyGeneratorMin implements IGeneratorMin {

    private Random nahodnyGenerator;

    public NahodnyGeneratorMin() {
        this.nahodnyGenerator = new Random();
    }

    @Override
    public ArrayList<Pozicia> generujMiny(int pocetMin, int pocetRiadkov, int pocetStlpcov) {
        ArrayList<Pozicia> pozicie = new ArrayList<>();
        while (pozicie.size() < pocetMin) {
            int riadok = this.nahodnyGenerator.nextInt(pocetRiadkov);
            int stlpec = this.nahodnyGenerator.nextInt(pocetStlpcov);
            Pozicia pozicia = new Pozicia(riadok, stlpec);
            if (!pozicie.contains(pozicia)) {
                pozicie.add(pozicia);
            }
        }
        return pozicie;
    }
}
