package optimisation.modele.algorithme;

import optimisation.modele.Clavier;

public class AlgorithmeAutre implements Algorithme{
	
	protected Clavier bestOf;
	
	public AlgorithmeAutre() {
		bestOf = new Clavier();
	}
	
	public Clavier getBestOf() {
		return bestOf;
	}
	
	@Override
	public String getNom() {
		return "AlgoAutre";
	}

}
