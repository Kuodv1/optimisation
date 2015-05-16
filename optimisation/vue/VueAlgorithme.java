package optimisation.vue;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import optimisation.modele.Modele;

public abstract class VueAlgorithme extends JPanel{

	protected Modele m;
	
	public VueAlgorithme(Modele m){
		super(new BorderLayout());
		this.setPreferredSize(new Dimension(800,200));
		this.m = m;
	}
	
	public void maj(Modele m){
		
	}
}
