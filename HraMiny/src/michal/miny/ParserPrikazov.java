package michal.miny;

public class ParserPrikazov {

    public IPrikaz parsujPrikaz(String vstup) {

        // "odkry 3 8"
        // "oznac 1 1"
        // "ukonci"

        String[] tokeny = vstup.split(" ");
        switch (tokeny[0]) {
            case "odkry": {
                if (tokeny.length < 3) {
                    return null;
                }
                Pozicia pozicia = this.parsujPoziciu(tokeny[1], tokeny[2]);
                if (pozicia == null) {
                    return null;
                }
                return new PrikazOdkry(pozicia.getRiadok(), pozicia.getStlpec());
            }

            case "oznac": {
                if (tokeny.length < 3) {
                    return null;
                }
                Pozicia pozicia = this.parsujPoziciu(tokeny[1], tokeny[2]);
                if (pozicia == null) {
                    return null;
                }
                return new PrikazOznac(pozicia.getRiadok(), pozicia.getStlpec());
            }

            case "ukonci": {
                return new PrikazUkonci();
            }

            default:
                return null;
        }



    }

    private Pozicia parsujPoziciu(String prvy, String druhy) {
        try {
            int riadok = Integer.parseInt(prvy);
            int stlpec = Integer.parseInt(druhy);
            return new Pozicia(riadok, stlpec);
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
