import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pes extends Zviera {

    private final List<String> prikazy;

    public Pes(long id, String meno) {
        super(id, meno);
        this.prikazy = new ArrayList<>();
        this.prikazy.add("sadni");
        this.prikazy.add("lahni");
        this.prikazy.add("cuvaj");
    }

    public List<String> getPrikazy() {
        // Vytvorenie kopie, ktora zabezpeci,
        // ze z vonku nebude mozne modifikovat atribut
        return new ArrayList<>(this.prikazy);
    }

    @Override
    public String getMeno() {
        return super.getMeno() + " woof woof";
    }

    @Override
    public String vydajZvuk() {
        return "haf woof";
    }
}
