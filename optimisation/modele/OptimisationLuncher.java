package optimisation.modele;

import java.awt.BorderLayout;
import javax.swing.JFrame;

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
        
        VueClavier vc = new VueClavier();
        add(vc,BorderLayout.CENTER);
        pack() ;
        setVisible(true);
    }

    public static void main(String[] args) {
        new OptimisationLuncher() ;
    }
}