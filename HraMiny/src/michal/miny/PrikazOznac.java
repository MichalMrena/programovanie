package michal.miny;

public class PrikazOznac extends SuradnicovyPrikaz {

    public PrikazOznac(int riadok, int stlpec) {
        super(riadok, stlpec);
    }

    @Override
    public void vykonaj(HraMiny hra) {
        if (hra.getPolicko(this.getRiadok(), this.getStlpec()).jeOznacene()) {
            hra.odznac(this.getRiadok(), this.getStlpec());
        } else {
            hra.oznac(this.getRiadok(), this.getStlpec());
        }
    }
}
