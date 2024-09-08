package main;

import base.Processo;
import escalonador.Fifo;

public class Main {

	public static void main(String[] args) {
		Processo[] p = {new Processo("p1", 7), new Processo("p2", 4), new Processo("p3", 1), new Processo("p4", 4)};
		Fifo f = new Fifo(p);
		f.start();
	}

}
