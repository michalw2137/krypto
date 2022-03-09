package szyfr;

public class Szyfr {
    private byte[] wiadomosc;
    private byte[] klucz;
    private byte[] outcome;

    public Szyfr(byte[] wiadomosc, byte[] klucz) {
        this.wiadomosc = wiadomosc;
        this.klucz = klucz;
    }

    public Szyfr(byte[] wiadomosc) {
        this.wiadomosc = wiadomosc;
    }

    private byte generujKlucz(){

    }
}
