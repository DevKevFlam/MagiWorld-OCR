package ui;

import Exception.deadException;
import Exception.wrongStatInitException;
import model.Guerrier;
import model.Mage;
import model.Personnage;
import model.Rodeur;

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

    /////////////////////////////////////////////////////////////////////////////////
    //Methode de test
    /**
     * Test de Verification du total de point Atribuer lors de la création du Personnage
     *
     * @param pointRestant : Nombre de points restant à Attribuer
     * @return true si la somme des points de compétence dépasse les point max
     */
    private boolean depasseMax(int pointRestant) {
        Boolean verifPoint = false;
        if (pointRestant < 0) {
            verifPoint = true;
            System.out.println("La somme de vos points de force , d'agilité et d'inteligence ne peuvent pas exéder votre niveau... ");
        }
        return verifPoint;
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
    //Methodes de Choix
    //Choix de Création
    /**
     * Choix de la Classe du personnage
     *
     * @return : Personnage transtypé en la classe de personnage choisie
     */
    private Personnage choixClasse() {
        boolean continuerSaisie = true;
        int choix = 0;
        Personnage joueur = null;
        do {
            System.out.println("Veuillez choisir la classe de votre personnage (1: Guerrier, 2: Rôdeur, 3: Mage.)");
            choix = this.saisirInt();
            switch (choix) {
                case 1:
                    continuerSaisie = false;
                    joueur = new Guerrier();
                    break;
                case 2:
                    continuerSaisie = false;
                    joueur = new Rodeur();
                    break;
                case 3:
                    continuerSaisie = false;
                    joueur = new Mage();
                    break;
                default:
                    continuerSaisie = true;
                    System.out.println("Mauvaise Saisie !!!");
                    break;
            }
            Controller.sc.reset();
        } while (continuerSaisie);
        return joueur;
    }

    /**
     * Méthode de choix du niveau du personnage
     *
     * @param joueur : joueur à modifier
     * @return : joueur modifié
     */
    private Personnage choixNiveau(Personnage joueur) {
        Boolean continuerSaisie = true;
        do {
            System.out.println("Niveau du personnage ? (de 1 à 100)");
            try {
                joueur.setNiveau(this.saisirInt());
                continuerSaisie = false;
            } catch (wrongStatInitException e) {
                System.out.println(e.getMessage());
                continuerSaisie = true;
            }
        } while (continuerSaisie);
        return joueur;
    }

    /**
     * Méthode de Choix des points de Force du Personnage
     *
     * @param joueur   : joueur à modifier
     * @param maxPoint : Point a distribué
     * @return joueur modifié
     */
    private Personnage choixForce(Personnage joueur, int maxPoint) {
        Boolean continuerSaisie = true;
        do {
            System.out.println("Force du personnage ?           Vous avez " + maxPoint + "points à distribuer.");
            try {
                joueur.setForce(this.saisirInt());
                continuerSaisie = false;
            } catch (wrongStatInitException e) {
                System.out.println(e.getMessage());
                continuerSaisie = true;
            }
        } while (continuerSaisie);
        return joueur;
    }

    /**
     * Méthode de Choix des points d'Agilité du Personnage
     *
     * @param joueur   : joueur à modifier
     * @param maxPoint : Point à distribuer
     * @return joueur modifié
     */
    private Personnage choixAgilite(Personnage joueur, int maxPoint) {
        Boolean continuerSaisie = true;
        do {
            System.out.println("Agilité du personnage ?         Vous avez " + maxPoint + "points à distribuer.");
            try {
                joueur.setAgilite(this.saisirInt());
                continuerSaisie = false;
            } catch (wrongStatInitException e) {
                System.out.println(e.getMessage());
                continuerSaisie = true;
            }
        } while (continuerSaisie);
        return joueur;
    }

    /**
     * Méthode de Choix des points d'Intelligence du Personnage
     *
     * @param joueur   : joueur à modifier
     * @param maxPoint : Point à distribuer
     * @return joueur modifié
     */
    private Personnage choixInteligence(Personnage joueur, int maxPoint) {
        Boolean continuerSaisie = true;
        do {
            System.out.println("Inteligence du personnage ?     Vous avez " + maxPoint + "points à distribuer.");
            try {
                joueur.setIntelligence(this.saisirInt());
                continuerSaisie = false;
            } catch (wrongStatInitException e) {
                System.out.println(e.getMessage());
                continuerSaisie = true;
            }
        } while (continuerSaisie);
        return joueur;
    }
    //Choix de gameplay
    /**
     * Méthode de Choix de l'attaque du personnage attaquant
     *
     * @param joueur : Personnage attaquant
     * @return : Dommage généré par l'attaque
     */
    private int choixAttaque(Personnage joueur) {
        boolean continuerSaisie;
        int damage = 0;
        do {
            System.out.println(joueur.getName() + " (" + joueur.getVie() + " Vitalité) Veuillez choisir votre Action (1: Attaque de base: " + joueur.getAttaqueBasique() + "    ; 2: Attaque Spéciale: " + joueur.getAttaqueSpeciale() + ".)");
            int choix = this.saisirInt();
            switch (choix) {
                case 1:
                    continuerSaisie = false;
                    damage = joueur.attaqueBasique();
                    break;
                case 2:
                    continuerSaisie = false;
                    damage = joueur.attaqueSpeciale();
                    break;
                default:
                    continuerSaisie = true;
                    System.out.println("Mauvaise Saisie !!!");
                    break;
            }
            Controller.sc.reset();
        } while (continuerSaisie);
        return damage;
    }

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
    //Phase de Gameplay
    /**
     * Méthode de création du Personnage
     *
     * @param name : Nom du Personnage
     * @return Personnage généré
     */
    private Personnage creerPersonnage(String name) {
        Boolean verifPoints;
        System.out.println("Création du personnage " + name);
        //Classe
        Personnage joueur = choixClasse();
        joueur.setName(name);
        //Niveau
        joueur = this.choixNiveau(joueur);
        int maxPoint = joueur.getNiveau();
        //Force
        do {joueur = this.choixForce(joueur, maxPoint);
            verifPoints = this.depasseMax(maxPoint - joueur.getForce());
        } while (verifPoints);
        maxPoint -= joueur.getForce();
        ////////////////////////////////////////////////
        //Agilité
        do {joueur = this.choixAgilite(joueur, maxPoint);
            verifPoints = this.depasseMax(maxPoint - joueur.getAgilite());
        } while (verifPoints);
        maxPoint -= joueur.getAgilite();
        //Intelligence
        do {joueur = this.choixInteligence(joueur, maxPoint);
            verifPoints = this.depasseMax(maxPoint - joueur.getIntelligence());
        } while (verifPoints);
        maxPoint -= joueur.getIntelligence();
        //Catch phrase
        System.out.println(joueur.getCatchPhrase());
        return joueur;
    }

    /**
     * Phase de Combat entre les 2 personnage
     *
     * @param joueur1 : Personnage attaquant en premier
     * @param joueur2 : Personnage attaquant en second
     * @return Personnage ayant gagné le combat
     */
    private Personnage combat(Personnage joueur1, Personnage joueur2) {
        Personnage winner = null;
        int damage;
        do {
            //Tour Joueur1
            damage = this.choixAttaque(joueur1);
            System.out.println(joueur2.getName() + ": Perd " + damage + " points de vie");
            try { joueur2.subitDegat(damage);
            } catch (deadException e) {
                System.out.println(e.getMessage());
                winner = joueur1;
                break;}
            //Tour Joueur2
            damage = this.choixAttaque(joueur2);
            System.out.println(joueur1.getName() + ": Perd " + damage + " points de vie");
            try { joueur1.subitDegat(damage);
            } catch (deadException e) {
                System.out.println(e.getMessage());
                winner = joueur2;
                break;}
        } while (winner == null);
        return winner;
    }
    /////////////////////////////////////////////////////////////////////////////////
    /**
     * Sequence principal: Combat entre joueur 1 et joueur 2
     */
    public void sequencePrincipal() {
        Personnage winner = null;
        Boolean rejouer = false;

        this.afficherBonjour();
        do {
            if (rejouer) {
                this.afficherReplay();
            }
            //Creation des personnage
            Personnage joueur1 = this.creerPersonnage("Joueur 1");
            Personnage joueur2 = this.creerPersonnage("Joueur 2");
            //FIGHT!!!!
            winner = this.combat(joueur1, joueur2);
            this.affichageWinner(winner);
            //RECOMMENCER?
            rejouer = this.askForReloadFight();
        } while (rejouer);
    }
}
