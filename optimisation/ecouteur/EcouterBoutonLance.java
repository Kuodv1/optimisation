package optimisation.ecouteur;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import optimisation.modele.algorithme.Algorithme;
import optimisation.modele.algorithme.AlgorithmeRecuitSimule;
import optimisation.modele.algorithme.AlgorithmeTabou;
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
		/*
		int temperature=0;
		double lambda=0;
		boolean b = true,c = true;
		while(b)
		{
			String t; 
			try
			{
				 t = JOptionPane.showInputDialog(null, "Veuillez rentrer une température", "Temperature", JOptionPane.QUESTION_MESSAGE);
				temperature = Integer.parseInt(t);
				b=false;
			}
		    catch(NumberFormatException e)
			{
		    	JOptionPane.showMessageDialog(null, "Veuillez rentrer une température exact", "Erreur", JOptionPane.ERROR_MESSAGE);
		    }
		    
		}
		
		while(c)
		{
			String t,s=""; 
			try
			{
				 t = JOptionPane.showInputDialog(null, "Veuillez le nombre lambda(compris entre 0.99 et 1)", "Lambda", JOptionPane.QUESTION_MESSAGE);
				lambda = Double.parseDouble(t);
				if(lambda>=1)
				{
					JOptionPane.showMessageDialog(null, "Ceci est supérieur à 1 ou égal", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					c=false;
				}
		
			}
		    catch(NumberFormatException e)
			{
		    	JOptionPane.showMessageDialog(null, "Veuillez rentrer un lambda exact\n"+s, "Erreur", JOptionPane.ERROR_MESSAGE);
		    }
		    
		}
	  
		ars.setK(lambda);
	        ars.setTemperature(temperature);
		ars.recuitSimule();
		
		vc.maj();
		*/
		va.maj();
	}
	
	

}
