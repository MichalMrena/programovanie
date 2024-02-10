public class Vysavac {

    private final String farba;
    private final int vykon;

    public Vysavac(String farba, int vykon) {
        this.farba = farba;
        this.vykon = vykon;
    }

    public String getFarba() {
        return this.farba;
    }

    public int getVykon() {
        return this.vykon;
    }
}