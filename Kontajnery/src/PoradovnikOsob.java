import java.util.*;

public class PoradovnikOsob {

    private final Deque<Osoba> poradovnik;
    private final Map<String, Osoba> indexMien;
    private final Map<String, Osoba> indexRodnychCisel;

    public PoradovnikOsob() {
        this.poradovnik = new LinkedList<>();
        this.indexMien = new HashMap<>();
        this.indexRodnychCisel = new TreeMap<>();
    }

    public void pridajOsobuNaZaciatok(Osoba o) {
        this.poradovnik.addFirst(o);
        this.zaIndexujOsobu(o);
    }

    public void pridajOsobuNaKoniec(Osoba o) {
        this.poradovnik.addLast(o);
        this.zaIndexujOsobu(o);
    }

    public Osoba getOsobaNaRade() {
        return this.poradovnik.peekFirst();
    }

    public void odstranOsobuNaRade() {
        Osoba o = this.poradovnik.pollFirst();
        if (o != null) {
            this.odIndexujOsobu(o);
        }
    }

    public int getPocetCakajucich() {
        return this.poradovnik.size();
    }

    public void vypisVsetkyOsoby() {
        for (Osoba o : this.poradovnik) {
            System.out.println(o);
        }
    }

    public Osoba najdiPodlaMena(String meno) {
        return this.indexMien.get(meno);
    }

    public Osoba najdiPodlaRodnehoCisla(String rodneCislo) {
        return this.indexRodnychCisel.get(rodneCislo);
    }

    private void zaIndexujOsobu(Osoba o) {
        this.indexMien.put(o.getMeno(), o);
        this.indexRodnychCisel.put(o.getRodneCislo(), o);
    }

    private void odIndexujOsobu(Osoba o) {
        this.indexMien.remove(o.getMeno());
        this.indexRodnychCisel.remove(o.getRodneCislo());
    }
}
