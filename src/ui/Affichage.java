package ui;

import model.Personnage;

public class Affichage {

    /**
     * Constante de Séparation Console
     */
    private static final String LINE_SEPARATOR = "+------------------------------------------------------------+";

    /////////////////////////////////////////////////////////////////////////////////
    //Methodes d'affichage
    /**
     * Affichage du Bandeau de Bienvenue
     */
    public void afficherBonjour() {
        System.out.println(LINE_SEPARATOR);
        System.out.println("                       Bienvenu");
        System.out.println("              Vous entrez dans l'arène !!!");
        System.out.println(LINE_SEPARATOR);
    }

    /**
     * Affichage du Bandeau de Nouvelle Partie
     */
    public void afficherReplay() {
        System.out.println(LINE_SEPARATOR);
        System.out.println("        Vous entrez de nouveau dans l'arène !!!");
        System.out.println(LINE_SEPARATOR);
    }

    /**
     * Affichage des messages de fin de combat: Vainqueur et traitemant du suicide du guerrier
     * @param winner : Gagnant du Combat
     */
    public void affichageWinner(Personnage winner){

        System.out.println(winner.getName() + " a Gagné le combat!!!");
        if (winner.getVie() == 0 || winner.getClass().getSimpleName() == "Guerrier") {
            System.out.println("              MAIS               ");
            System.out.println(winner.getName() + " s'est suicidé lors de rage frénétique !!!");
        }
    }

}
