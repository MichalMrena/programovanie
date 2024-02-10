package michal.miny;

import java.util.Objects;

public class Pozicia {

    private int riadok;
    private int stlpec;

    public Pozicia(int riadok, int stlpec) {
        this.riadok = riadok;
        this.stlpec = stlpec;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pozicia pozicia = (Pozicia) o;
        return riadok == pozicia.riadok && stlpec == pozicia.stlpec;
    }

    @Override
    public int hashCode() {
        return Objects.hash(riadok, stlpec);
    }

    public int getRiadok() {
        return this.riadok;
    }

    public int getStlpec() {
        return this.stlpec;
    }

    public boolean jeRovnaka(Pozicia ina) {
        return this.riadok == ina.getRiadok() && this.stlpec == ina.getStlpec();
    }

    public boolean jeRovnaka(int riadok, int stlpec) {
        return this.riadok == riadok && this.stlpec == stlpec;
    }
}









