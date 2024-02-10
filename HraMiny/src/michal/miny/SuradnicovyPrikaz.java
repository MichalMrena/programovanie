package michal.miny;

public abstract class SuradnicovyPrikaz implements IPrikaz {
    private int riadok;
    private int stlpec;

    public SuradnicovyPrikaz(int riadok, int stlpec) {
        this.riadok = riadok;
        this.stlpec = stlpec;
    }

    protected int getRiadok() {
        return this.riadok;
    }

    protected int getStlpec() {
        return this.stlpec;
    }
}
