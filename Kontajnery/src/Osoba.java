public class Osoba {

    private final String meno;
    private final String rodneCislo;

    public Osoba(String meno, String rodneCislo) {
        this.meno = meno;
        this.rodneCislo = rodneCislo;
    }

    public String getMeno() {
        return this.meno;
    }

    public String getRodneCislo() {
        return this.rodneCislo;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "meno='" + this.meno + '\'' +
                ", rodneCislo='" + this.rodneCislo + '\'' +
                '}';
    }
}
