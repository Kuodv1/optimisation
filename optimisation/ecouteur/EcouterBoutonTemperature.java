package optimisation.ecouteur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import optimisation.modele.Modele;
import optimisation.modele.algorithme.Algorithme;
import optimisation.modele.algorithme.AlgorithmeRecuitSimule;
import optimisation.vue.recuit.VueInfoAlgoRecuit;

public class EcouterBoutonTemperature implements ActionListener{

	private VueInfoAlgoRecuit v;
	private Algorithme m;
	
	public EcouterBoutonTemperature(Algorithme m,VueInfoAlgoRecuit v)
	{
		this.m = m;
		this.v= v;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		@SuppressWarnings("unused")
		double temperature=0;
		boolean b = true;
		while(b)
		{
			String t; 
			try
			{
				 t = JOptionPane.showInputDialog(null, "Veuillez rentrer une température", "Temperature", JOptionPane.QUESTION_MESSAGE);
				temperature = Integer.parseInt(t);
				((AlgorithmeRecuitSimule)m).setTemperature(temperature);
				b=false;
			}
		    catch(NumberFormatException e)
			{
		    	JOptionPane.showMessageDialog(null, "Veuillez rentrer une température exact", "Erreur", JOptionPane.ERROR_MESSAGE);
		    }
		    
		}
		v.maj();
		
	}
}