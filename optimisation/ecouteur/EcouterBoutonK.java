package optimisation.ecouteur;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import optimisation.modele.Modele;
import optimisation.modele.algorithme.Algorithme;
import optimisation.modele.algorithme.AlgorithmeRecuitSimule;
import optimisation.vue.recuit.VueInfoAlgoRecuit;

public class EcouterBoutonK implements ActionListener{

	private Algorithme m;
	private VueInfoAlgoRecuit v;
	JTextField taille;
	
	public EcouterBoutonK(Algorithme m,VueInfoAlgoRecuit v)
	{
		this.m = m;
		this.v = v;
		taille = new JTextField(10);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		@SuppressWarnings("unused")
		double lambda=0;
		JPanel redim = new JPanel(new GridLayout(1,2));
		redim.add(new JLabel("Lambda : (min 0.99 - max 1) : "));
		redim.add(taille);

			String s=""; 
			try
			{
				int t = JOptionPane.showConfirmDialog(null, redim, 
						"Lambda", JOptionPane.OK_CANCEL_OPTION);
				if(t == JOptionPane.OK_OPTION) {
					
					lambda = Double.parseDouble(taille.getText());
					if(lambda>=1 || lambda<=0.99)
					{
						JOptionPane.showMessageDialog(null, "Ceci est supérieur à  1 ou inférieure à 0.99", "Erreur", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						
						((AlgorithmeRecuitSimule)m).setK(lambda);
					}
				}
		
			}
		    catch(NumberFormatException e)
			{
		    	JOptionPane.showMessageDialog(null, "Veuillez rentrer un lambda exact\n"+s, "Erreur", JOptionPane.ERROR_MESSAGE);
		    }
		    
		
		v.maj();
		
	}
}
