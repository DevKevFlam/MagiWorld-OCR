package ui;

import model.Personnage;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Controller {

    /**
     * Scanner pour saisie User
     */
    public static Scanner sc = new Scanner(System.in);

    /**
     * Constante de Séparation Console
     */
    private static final String LINE_SEPARATOR = "+------------------------------------------------------------+";

    /////////////////////////////////////////////////////////////////////////////////
    //Methodes de saisie

    /**
     * Boucle de saisie d'un Entier
     *
     * @return Entier Corespondant au choix de l'utilisateur
     */
    private int saisirInt() {
        int choix = 0;
        Boolean test;
        do {
            test = false;
            try {
                choix = Controller.sc.nextInt();
            } catch (InputMismatchException e) {
                // System.out.println("Error: 1 EXPLODE STRING!!!!! " + e.getClass().getName());
                test = true;
            } catch (NoSuchElementException e) {
                // System.out.println("Error: 2 EXPLODE STRING!!!!! " + e.getClass().getName());
                test = true;
            } catch (IllegalStateException e) {
                // System.out.println("Error: 3 EXPLODE STRING!!!!! " + e.getClass().getName());
                test = true;
            } finally {
                sc.nextLine();
            }
        } while (test);
        return choix;
    }

    /**
     * Demande de réponse binaire (oui ou non), Boucle de saisie d'un Boolean
     *
     * @return : True si Oui , False si non
     */
    private boolean demandeOuiNon() {

        Boolean ok = false;

        int choix;
        do {
            System.out.println("1 : OUI        0 : NON");
            choix = this.saisirInt();
        } while (choix != 0 && choix != 1);
        ok = (choix == 1);

        return ok;
    }

    /**
     * Affichage des messages de fin de combat: Vainqueur et traitemant du suicide du guerrier
     * @param winner : Gagnant du Combat
     */
    private void affichageWinner(Personnage winner){

        System.out.println(winner.getName() + " a Gagné le combat!!!");
        if (winner.getVie() == 0 || winner.getClass().getSimpleName() == "Guerrier") {
            System.out.println("              MAIS               ");
            System.out.println(winner.getName() + " s'est suicidé lors de rage frénétique !!!");
        }
    }

    /////////////////////////////////////////////////////////////////////////////////
    //Methodes d'affichage

    /**
     * Affichage du Bandeau de Bienvenue
     */
    private void afficherBonjour() {
        System.out.println(LINE_SEPARATOR);
        System.out.println("                       Bienvenu");
        System.out.println("              Vous entrez dans l'arène !!!");
        System.out.println(LINE_SEPARATOR);
    }

    /**
     * Affichage du Bandeau de Nouvelle Partie
     */
    private void afficherReplay() {
        System.out.println(LINE_SEPARATOR);
        System.out.println("        Vous entrez de nouveau dans l'arène !!!");
        System.out.println(LINE_SEPARATOR);
    }

    /////////////////////////////////////////////////////////////////////////////////
    //Methodes de Choix
    /**
     * Demande pour recommencer le combat
     * @return : true si oui; false si non
     */
    private Boolean askForReloadFight() {
        System.out.println("Voulez-vous rejouer?");
        Boolean rejouer = this.demandeOuiNon();
        return rejouer;
    }
    /////////////////////////////////////////////////////////////////////////////////
    /**
     * Sequence principal: Combat entre joueur 1 et joueur 2
     */
    public void sequencePrincipal(){
        Personnage winner = null;
        Boolean rejouer = false;

        this.afficherBonjour();
        do {
            if (rejouer) {
                this.afficherReplay();
            }
            //Creation des personnage
            Personnage joueur1 = null;
            Personnage joueur2 = null;
            //FIGHT!!!!
            winner = null;
            this.affichageWinner(winner);
            //RECOMMENCER?
            rejouer = true;
        } while (rejouer);

    }
}
