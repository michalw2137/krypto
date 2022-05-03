package szyfr;

import com.github.iarks.RandomOrgAPI.InvalidResponseException;
import com.github.iarks.RandomOrgAPI.RandomNumber;

import java.util.Random;

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
//        new Random().nextBytes(klucz);
    }

    public void szyfruj() {
        this.outcome = new byte[(int) wiadomosc.length];
        int i = 0;
        while( i < wiadomosc.length - wiadomosc[wiadomosc.length - 1] -1) {
            outcome[i] = (byte) (wiadomosc[i] ^ klucz[i]);
            i++;
        }
        while( i<wiadomosc.length){
            outcome[i] = wiadomosc[i];
            i++;
        }
    }


    public byte[] getKlucz() {
        return klucz;
    }

    public byte[] getOutcome() {
        return outcome;
    }
}
