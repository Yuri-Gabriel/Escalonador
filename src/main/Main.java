package main;

import base.Processo;
import escalonador.Fifo;
import escalonador.Sjf;

public class Main {

	public static void main(String[] args) {
		Processo[] p = {new Processo("p1", 0, 24), new Processo("p2", 0, 3), new Processo("p3", 0, 3)};
		
		
		Sjf s = new Sjf(p);
		System.out.println("---------------");
		Fifo f = new Fifo(p);
	}

}
