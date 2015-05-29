package optimisation.ecouteur;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import optimisation.modele.algorithme.Algorithme;
import optimisation.modele.algorithme.AlgorithmeRecuitSimule;
import optimisation.vue.VueAlgorithme;
import optimisation.vue.recuit.VueAlgorithmeRecuitSimule;

public class EcouterBoutonLance implements ActionListener{
	
	private Algorithme a;
	private VueAlgorithme va;
	
	public EcouterBoutonLance(Algorithme a,VueAlgorithme va)
	{
		this.a = a;
		this.va = va;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(a.getNom()=="Algorithme Recuit Simule")
		{
			((AlgorithmeRecuitSimule)a).recuitSimule();
			va.maj();
		}
		else if(a.getNom()=="Recherche Tabou")
		{
			va.maj();
		}
		else
		{
			System.out.println("probleme");
		}
		
	}
	
	

}
