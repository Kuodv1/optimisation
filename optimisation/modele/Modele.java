package optimisation.modele;

import java.util.Observable;

import optimisation.modele.algorithme.Algorithme;
import optimisation.modele.algorithme.AlgorithmeAutre;
import optimisation.modele.algorithme.AlgorithmeGenetique;

public class Modele extends Observable{

	protected Algorithme algo;
	protected int codeUpdate;
	protected Thread t;
	
	public Modele() {
		algo = new AlgorithmeGenetique();
		codeUpdate =0;
	}
	
	public void setAlgorithme(String algo) {
		if(!algo.equals(this.algo.getNom())) { //si changement d'algo
			codeUpdate = 1;
			switch(algo) {
			case "Algorithme Genetique":
				this.algo =new AlgorithmeGenetique();
				System.out.println("Algo genetique choisi");
				break;
	
			case "AlgoAutre":
				System.out.println("AlgoAutre");
				this.algo = new AlgorithmeAutre();
				break;
				
				default:
					System.out.println("cas default de Modele.setAlgorithme");
			}
			changementAffichage();
		}
	}
	
	public int getCodeUpdate() {
		return codeUpdate;
	}
	
	public String getNomAlgo() {
		return algo.getNom();
	}

	public void changementAffichage() {

		t = new Thread() {
			public void run() {
				setChanged();
				notifyObservers();
			  }};
		t.start();
		
		
	}
	
}
