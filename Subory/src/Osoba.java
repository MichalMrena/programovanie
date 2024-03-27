public class Osoba {
    private final int id;
    private final String rodneCislo;
    private final String meno;

    public Osoba(int id, String rodneCislo, String meno) {
        this.id = id;
        this.rodneCislo = rodneCislo;
        this.meno = meno;
    }

    public int getId() {
        return this.id;
    }

    public String getRodneCislo() {
        return this.rodneCislo;
    }

    public String getMeno() {
        return this.meno;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Osoba{" +
                "id=" + this.id +
                ", rodneCislo=" + this.rodneCislo +
                ", meno=" + this.meno +
                '}';
    }
}
