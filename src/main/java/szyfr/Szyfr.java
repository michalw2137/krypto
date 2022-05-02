package szyfr;

import java.util.Random;

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
        this.klucz = new byte[(int)wiadomosc.length];
        Random r = new Random();
        r.nextBytes(klucz);
    }

    public void szyfruj() {
        this.outcome = new byte[(int) wiadomosc.length];
        for (int i = 0; i < wiadomosc.length; i++) {
            outcome[i] = (byte) (wiadomosc[i] ^ klucz[i]);
        }
    }

    public byte[] getWiadomosc() {
        return wiadomosc;
    }

    public byte[] getKlucz() {
        return klucz;
    }

    public byte[] getOutcome() {
        return outcome;
    }
}
