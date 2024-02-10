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
        List<String> kopia = new ArrayList<>();
        for (String prikaz : this.prikazy) {
            kopia.add(prikaz);
        }
        return kopia;
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
