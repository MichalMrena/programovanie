package michal.miny;

public class Policko implements IPopisPolicka {

    private boolean maMinu;
    private int pocetMinVOkoli;
    private boolean jeOdkryte;
    private boolean jeOznacene;

    public Policko(boolean maMinu, int pocetMinVOkoli) {
        this.maMinu = maMinu;
        this.pocetMinVOkoli = pocetMinVOkoli;
        this.jeOdkryte = false;
        this.jeOznacene = false;
    }

    public void odkry() {
        this.jeOdkryte = true;
    }

    @Override
    public boolean obsahujeMinu() {
        return this.maMinu;
    }

    public void oznac() {
        this.jeOznacene = true;
    }

    public void odznac() {
        this.jeOznacene = false;
    }

    @Override
    public int getPocetMinVOkoli() {
        return this.pocetMinVOkoli;
    }

    @Override
    public boolean jeOdkryte() {
        return this.jeOdkryte;
    }

    @Override
    public boolean jeOznacene() {
        return this.jeOznacene;
    }
}








