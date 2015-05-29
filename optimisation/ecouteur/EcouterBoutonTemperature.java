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

public class EcouterBoutonTemperature implements ActionListener{

	private VueInfoAlgoRecuit v;
	private Algorithme m;
	protected JTextField taille;
	
	public EcouterBoutonTemperature(Algorithme m,VueInfoAlgoRecuit v)
	{
		this.m = m;
		this.v= v;
		taille = new JTextField(10);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		@SuppressWarnings("unused")
		double temperature=0;
		JPanel redim = new JPanel(new GridLayout(1,2));
		redim.add(new JLabel("Temperature : "));
		redim.add(taille);
			try
			{
				int t = JOptionPane.showConfirmDialog(null, redim, 
						"Temperature", JOptionPane.OK_CANCEL_OPTION);
				if(t == JOptionPane.OK_OPTION) {
					temperature = Integer.parseInt(taille.getText());
					((AlgorithmeRecuitSimule)m).setTemperature(temperature);
				}
			}
		    catch(NumberFormatException e)
			{
		    	JOptionPane.showMessageDialog(null, "Veuillez rentrer une température exact", "Erreur", JOptionPane.ERROR_MESSAGE);
		    }
		    
		v.maj();
		
	}
}
