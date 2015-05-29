package optimisation.ecouteur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import optimisation.modele.Modele;
import optimisation.modele.algorithme.Algorithme;
import optimisation.modele.algorithme.AlgorithmeRecuitSimule;
import optimisation.vue.recuit.VueInfoAlgoRecuit;

public class EcouterBoutonK implements ActionListener{

	private Algorithme m;
	private VueInfoAlgoRecuit v;
	
	public EcouterBoutonK(Algorithme m,VueInfoAlgoRecuit v)
	{
		this.m = m;
		this.v = v;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		@SuppressWarnings("unused")
		double lambda=0;
		boolean c = true;
		while(c)
		{
			String t,s=""; 
			try
			{
				 t = JOptionPane.showInputDialog(null, "Veuillez le nombre lambda(compris entre 0.99 et 1)", "Lambda", JOptionPane.QUESTION_MESSAGE);
				lambda = Double.parseDouble(t);
				if(lambda>=1)
				{
					JOptionPane.showMessageDialog(null, "Ceci est supérieur à  1 ou égal", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					c=false;
					((AlgorithmeRecuitSimule)m).setK(lambda);
				}
		
			}
		    catch(NumberFormatException e)
			{
		    	JOptionPane.showMessageDialog(null, "Veuillez rentrer un lambda exact\n"+s, "Erreur", JOptionPane.ERROR_MESSAGE);
		    }
		    
		}
		v.maj();
		
	}
}
