public class Main {

    public static void main(String[] args) {
        PoradovnikOsob poradovnik = new PoradovnikOsob();
        poradovnik.pridajOsobuNaZaciatok(new Osoba("Jack O'neill", "6404123660"));
        poradovnik.pridajOsobuNaKoniec(new Osoba("Samantha Carter", "7205133419"));

        Osoba jack = poradovnik.najdiPodlaMena("Jack O'neill");
        Osoba samantha = poradovnik.najdiPodlaRodnehoCisla("7205133419");
        Osoba tealc = poradovnik.najdiPodlaMena("Teal'c");
        if (tealc == null) {
            System.out.println("Teal'c tam ale nie je!");
        }

        poradovnik.vypisVsetkyOsoby();
    }
}
