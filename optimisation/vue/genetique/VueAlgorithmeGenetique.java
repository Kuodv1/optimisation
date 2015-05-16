package optimisation.vue.genetique;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;

import optimisation.modele.Modele;
import optimisation.vue.VueAlgorithme;
import optimisation.vue.VueClavier;

public class VueAlgorithmeGenetique extends VueAlgorithme{

	protected GridLayout grid;
	protected VueClavier[][] tabClavier;
	
	public VueAlgorithmeGenetique(Modele m) {
		super(m);
		grid = new GridLayout(2,4);
		tabClavier = new VueClavier[2][4];
		grid.setHgap(7);
		grid.setVgap(15);
		this.setBackground(Color.BLACK);
		this.setLayout(grid);
		for(int i = 0; i<tabClavier.length;i++) {
			for(int j = 0; j<tabClavier[i].length;j++) {
				tabClavier[i][j] = new VueClavier();
				this.add(tabClavier[i][j]);
			}
		}
	}
	
	@Override
	public void maj(Modele m) {
		// TODO Auto-generated method stub
		
	}

}
