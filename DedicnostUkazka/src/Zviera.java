public abstract class Zviera {
    private final long id;
    private final String meno;

    public Zviera(long id, String meno) {
        this.id = id;
        this.meno = meno;
    }

    public long getId() {
        return this.id;
    }

    public String getMeno() {
        return this.meno;
    }

    public abstract String vydajZvuk();
}
