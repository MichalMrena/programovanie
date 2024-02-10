import java.util.ArrayList;

public class ZvieraciaKlinika {
    private final ArrayList<Zviera> zvierata;

    public ZvieraciaKlinika() {
        this.zvierata = new ArrayList<>();
    }

    public void pridajZviera(Zviera zviera) {
        this.zvierata.add(zviera);
    }

    public void vypisMena() {
        for (Zviera zviera : this.zvierata) {
            System.out.println(zviera.getMeno());
        }
    }

    public void odpocuvajZvierata() {
        for (Zviera zviera : this.zvierata) {
            System.out.println(zviera.vydajZvuk());
        }
    }
}
