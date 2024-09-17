import base.Processo;

import escalonador.Fifo;
import escalonador.Sjf;
import escalonador.Strf;

public class Main {

    public static void main(String[] args) {
        Processo[] p = { new Processo("p1", 0, 7), new Processo("p2", 2, 4), new Processo("p3", 4, 1), new Processo("p4", 5, 4) };
        Fifo fifo = new Fifo(p);
        Sjf sjf = new Sjf(p);
        Strf strf = new Strf(p);
        
        strf.start();
        
        
       

    }

}
