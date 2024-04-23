public enum StavHry {
    PREBIEHA("Prebieha"),
    NEZACALA("Nezacala"),
    UKONCENA("Ukoncena");

    private final String nazov;

    StavHry(String nazov) {
        this.nazov = nazov;
    }

    public String getNazov() {
        return this.nazov;
    }
}
