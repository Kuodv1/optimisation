package optimisation.vue.recuit;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;

import optimisation.modele.Clavier;
import optimisation.modele.Modele;
import optimisation.modele.algorithme.AlgorithmeRecuitSimule;
import optimisation.vue.VueAlgorithme;
import optimisation.vue.VueClavier;

public class VueAlgorithmeRecuitSimule extends VueAlgorithme{

	protected GridLayout grid;
	protected VueClavier[][] tabClavier;
	
	//Ton algo te servira de Modele
	protected AlgorithmeRecuitSimule ars;
	
	public VueAlgorithmeRecuitSimule(Modele m) {
		super(m);
		
		//Tu stockes ton "modele"
		//A voir si on passe pas en modele Observer/Observable
		//Avec l'algo le Modèle (Observable) et la vue, l'observer
		this.ars = (AlgorithmeRecuitSimule)m.getAlgo();
		grid = new GridLayout(2,4);
		tabClavier = new VueClavier[2][4];
		grid.setHgap(7);
		grid.setVgap(15);
		this.setBackground(Color.BLACK);
		this.setLayout(grid);
		for(int i = 0; i<tabClavier.length;i++) {
			for(int j = 0; j<tabClavier[i].length;j++) {
				tabClavier[i][j] = new VueClavier(new Clavier());
				this.add(tabClavier[i][j]);
			}
		}
	}
	
	@Override
	public void maj() {
	
	}

}
