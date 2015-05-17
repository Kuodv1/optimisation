package optimisation.modele.algorithme;

import optimisation.modele.Clavier;

public class AlgorithmeTabou implements Algorithme{
	
	protected Clavier bestOf;
	
	public AlgorithmeTabou() {
		bestOf = new Clavier();
	}
	
	public Clavier getBestOf() {
		return bestOf;
	}
	
	@Override
	public String getNom() {
		return "Recherche Tabou";
	}

}
