package optimisation.vue;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import optimisation.modele.algorithme.Algorithme;

public class VueInfo extends JPanel {

	Algorithme a;
	JLabel ite;
	JLabel valFoncObj;
	
	public VueInfo(Algorithme a) {
		super(new BorderLayout());
		this.a =a;
		JLabel nomAlgo = new JLabel("Algorithme courant : "+a.getNom());
		JLabel ite = new JLabel("Nombre d'itération : ");
		JLabel valFoncObj = new JLabel("Valeur fonction objectif de la meilleur configuration : ");
		this.add(nomAlgo,BorderLayout.NORTH);
		this.add(ite,BorderLayout.CENTER);
		this.add(valFoncObj,BorderLayout.SOUTH);
	}
	
	public void maj(Algorithme a) {
		ite.setText("Nombre d'itération : "+"a.getNbrIte()");
		valFoncObj.setText("Valeur fonction objectif de la meilleur configuration : "+"a.getValConfigCourante()");
	}
}
