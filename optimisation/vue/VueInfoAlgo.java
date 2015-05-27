package optimisation.vue;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import optimisation.modele.Modele;
import optimisation.modele.algorithme.Algorithme;

public abstract class VueInfoAlgo extends JPanel{

	protected Algorithme m;
	
	public VueInfoAlgo(Algorithme m){
		super(new BorderLayout());
		this.setPreferredSize(new Dimension(400,200));
		this.m = m;
	}
	
	public abstract void maj();
}
