package optimisation.ecouteur;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import optimisation.modele.algorithme.Algorithme;
import optimisation.modele.algorithme.AlgorithmeRecuitSimule;
import optimisation.vue.VueAlgorithme;
import optimisation.vue.recuit.VueAlgorithmeRecuitSimule;

public class EcouterBoutonLance implements ActionListener{
	
	private Algorithme a;
	private VueAlgorithme va;
	JTextField taille;
	
	public EcouterBoutonLance(Algorithme a,VueAlgorithme va)
	{
		this.a = a;
		this.va = va;
		taille = new JTextField(5);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		boolean ok = false;
		JPanel redim = new JPanel(new GridLayout(1,2));
		redim.add(new JLabel("Rafraîchissement : (min 1) : "));
		redim.add(taille);
		int result = JOptionPane.showConfirmDialog(null, redim, 
		"Refresh", JOptionPane.OK_CANCEL_OPTION);//Fenetre 1 : Recupere taille souhaite.
		if (result == JOptionPane.OK_OPTION) {
			int refresh = 0;
			try {
				refresh = Integer.parseInt(taille.getText());
					if(refresh<1) { refresh = 1; }
					a.setRefresh(refresh);
					ok = true;
			} catch(NumberFormatException nfe) {
				//Les informations rentrees dans la zone de texte ne sont pas des nombres.
				JOptionPane.showMessageDialog(null, "Taille mal renseingnée. Entrer des chiffres.","Erreur",JOptionPane.WARNING_MESSAGE);

			}//end catch		
		}//end if result
		
		if(ok) {
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
	
	

}
