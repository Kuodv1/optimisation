package optimisation.ecouteur;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import optimisation.modele.algorithme.AlgorithmeTabou;

public class EcouteurBoutonListeTabou implements ActionListener{

	AlgorithmeTabou at;
	JLabel jl;
	JTextField taille;
	
	public EcouteurBoutonListeTabou(AlgorithmeTabou at, JLabel jl) {
		this.at = at;
		this.jl = jl;
		taille = new JTextField(2);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JPanel redim = new JPanel(new GridLayout(1,2));
		redim.add(new JLabel("Nouvelle taille liste Tabou : (min 1, max 100) : "));
		redim.add(taille);
		int result = JOptionPane.showConfirmDialog(null, redim, 
		"Nouvelle taille", JOptionPane.OK_CANCEL_OPTION);//Fenetre 1 : Recupere taille souhaite.
		if (result == JOptionPane.OK_OPTION) {
			int nbrCase = 0;
			try {
				nbrCase = Integer.parseInt(taille.getText());
					if(nbrCase<1) { nbrCase = 1; }
					if(nbrCase>100) { nbrCase = 100;}
					at.setTailleTabou(nbrCase);
					jl.setText(": "+at.getTailleTabou());
			} catch(NumberFormatException nfe) {
				//Les informations rentrees dans la zone de texte ne sont pas des nombres.
				JOptionPane.showMessageDialog(null, "Taille mal renseingnée. Entrer des chiffres.","Erreur",JOptionPane.WARNING_MESSAGE);

			}//end catch		
		}//end if result
		
	}

	
	
}
