package optimisation.modele.algorithme;


public interface Algorithme {
	
	public AlgorithmeRecuitSimule getAlgorithmeRecuitSimule();
	public String getNom();
	public void setTemperature(double temperature);
	public void setK(double lambda);
	public double getTemperature();
	public double getK();
	public char[][] getTamponFinal();
	public int calculEnergie(char[][] tampon);
	public int getNbIteration();
}
