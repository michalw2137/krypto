package szyfr;

import java.util.Random;
import com.github.iarks.RandomOrgAPI.InvalidMethodCallException;
import com.github.iarks.RandomOrgAPI.InvalidResponseException;
import com.github.iarks.RandomOrgAPI.RandomNumber;

public class Szyfr {
    private byte[] wiadomosc;
    private byte[] klucz;
    private byte[] outcome;

    public Szyfr(byte[] wiadomosc, byte[] klucz) {
        this.wiadomosc = wiadomosc;
        this.klucz = klucz;
    }

    public Szyfr(byte[] wiadomosc) throws InvalidResponseException {
        this.wiadomosc = wiadomosc;
        this.klucz = new byte[(int)wiadomosc.length];
        RandomNumber rn = new RandomNumber("5e860256-796f-4718-b356-bbbc260f1c75");
        rn.generate(wiadomosc.length, 255, 0, true, "method");
        for (int i = 0; i < wiadomosc.length; i++) {
            klucz[i] = (byte)rn.getElementAt(i);
        }
    }

    public void szyfruj() {
        this.outcome = new byte[(int) wiadomosc.length];
        for (int i = 0; i < wiadomosc.length; i++) {
            outcome[i] = (byte) (wiadomosc[i] ^ klucz[i]);
        }
    }

    public void setWiadomosc(byte[] wiadomosc) {
        this.wiadomosc = wiadomosc;
    }

    public void setKlucz(byte[] klucz) {
        this.klucz = klucz;
    }

    public void setOutcome(byte[] outcome) {
        this.outcome = outcome;
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
