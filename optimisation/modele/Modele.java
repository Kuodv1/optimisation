package optimisation.modele;

import java.util.Observable;

import optimisation.modele.algorithme.Algorithme;
import optimisation.modele.algorithme.AlgorithmeTabou;
import optimisation.modele.algorithme.AlgorithmeRecuitSimule;

public class Modele extends Observable{

	protected Algorithme algo;
	protected int codeUpdate;
	protected Thread t;
	
	public Modele() {
		algo = new AlgorithmeRecuitSimule();
		codeUpdate =0;
	}
	
	public void setAlgorithme(String algo) {
		if(!algo.equals(this.algo.getNom())) { //si changement d'algo
			codeUpdate = 1;
			switch(algo) {
			case "Algorithme Recuit Simule":
				this.algo =new AlgorithmeRecuitSimule();
				System.out.println("Algo Recuit Simule choisi");
				break;
	
			case "Recherche Tabou":
				System.out.println("Algo Tabou");
				this.algo = new AlgorithmeTabou();
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

	public Algorithme getAlgo() {
		return algo;
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
