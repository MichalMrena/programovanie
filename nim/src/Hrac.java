public abstract class Hrac {
    private static int pocetInstancii = 0;

    private final String meno;

    public static int getPocetInstancii() {
        return Hrac.pocetInstancii;
    }

    public Hrac(String meno) {
        pocetInstancii++;
        this.meno = meno;
    }

    public String getMeno() {
        return this.meno;
    }

    public abstract void zober(HraNim hra);
}
