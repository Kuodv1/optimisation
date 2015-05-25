package optimisation.ecouteur;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import optimisation.modele.algorithme.AlgorithmeRecuitSimule;
import optimisation.vue.recuit.VueAlgorithmeRecuitSimule;

public class EcouterBoutonLance implements ActionListener{
	
	private AlgorithmeRecuitSimule ars;
	private VueAlgorithmeRecuitSimule vc;
	
	public EcouterBoutonLance(AlgorithmeRecuitSimule ars,VueAlgorithmeRecuitSimule vc)
	{
		this.ars = ars;
		this.vc = vc;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		int temperature=0;
		boolean b = true;
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
	  

	    ars.setTemperature(temperature);
		ars.recuitSimule();
		
		vc.maj();
		
	}
	
	

}
