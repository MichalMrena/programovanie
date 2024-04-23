public enum StavHry {
    NEZACALA("Nezacala"),
    PREBIEHA("Prebieha"),
    SKONCILA("Skoncila");

    private final String nazov;

    private StavHry(String nazov) {
        this.nazov = nazov;
    }

    public String getNazov() {
        return this.nazov;
    }
}
