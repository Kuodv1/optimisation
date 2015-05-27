package optimisation.vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import optimisation.ecouteur.EcouterBoutonLance;
import optimisation.modele.algorithme.Algorithme;

public class VueInfo extends JPanel {

	GridLayout gl;
	VueInfoAlgo via;
	Algorithme a;
	JLabel ite;
	JLabel valFoncObj;
	JButton jb;
	
	public VueInfo(Algorithme a, VueAlgorithme va, VueInfoAlgo via) {
		super(new BorderLayout());
		this.a =a;
		this.via = via;
		gl = new GridLayout(5,1);
		setLayout(gl);
		JLabel nomAlgo = new JLabel("Algorithme courant : "+a.getNom());
		JLabel ite = new JLabel("Nombre d'itération : ");
		JLabel valFoncObj = new JLabel("Valeur fonction objectif de la meilleur configuration : ");
		this.add(via);
		this.add(nomAlgo);
		this.add(ite);
		this.add(valFoncObj);
		jb = new JButton("Lance");
		jb.addActionListener(new EcouterBoutonLance(a,va));
		this.add(jb);
	}
	
	public void maj(Algorithme a) {
		via.maj();
		ite.setText("Nombre d'itération : "+"a.getNbrIte()");
		valFoncObj.setText("Valeur fonction objectif de la meilleur configuration : "+"a.getValConfigCourante()");
	}
}
