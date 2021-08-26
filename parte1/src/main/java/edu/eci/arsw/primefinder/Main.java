package edu.eci.arsw.primefinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
//		PrimeFinderThread pft=new PrimeFinderThread(0, 30000000);//
//		pft.start();
		int nThreads = 10;
		if (nThreads <= 0 || nThreads > 30000001) nThreads = 1;
		int seccion = 30000001/nThreads;
		if (30000001 % nThreads != 0) {nThreads++;}
		List<PrimeFinderThread> threads = new ArrayList<PrimeFinderThread>(nThreads);
		for (int i=0; i<nThreads; i++) {
			threads.add(i, new PrimeFinderThread(i*seccion, Math.min(30000000, (i+1)*seccion-1)));
			threads.get(i).start();
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

		}
		for (PrimeFinderThread t: threads) {
			t.stop();
		}
		new Scanner(System.in).nextLine();

	}

}
