package optimisation.modele;

import java.awt.BorderLayout;
import javax.swing.JFrame;

import optimisation.vue.VueBas;
import optimisation.vue.VueCentral;
import optimisation.vue.VueClavier;

/**
 * Luncher du Toucan
 * @author Louis Mougin
 * @version Octobre 2014
 */

public class OptimisationLuncher extends JFrame {
    
    public OptimisationLuncher() {
        super("Projet Optimisation. Agencement clavier");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Modele m = new Modele();
        //VueClavier vc = new VueClavier();
        VueCentral vc = new VueCentral(m);
        add(vc,BorderLayout.CENTER);
        VueBas vb = new VueBas(m);
        add(vb, BorderLayout.SOUTH);
        pack() ;
        setVisible(true);
    }

    public static void main(String[] args) {
        new OptimisationLuncher() ;
    }
}