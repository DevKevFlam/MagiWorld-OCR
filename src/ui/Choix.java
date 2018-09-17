package ui;

import Exception.deadException;
import Exception.wrongStatInitException;
import model.Guerrier;
import model.Mage;
import model.Personnage;
import model.Rodeur;


public class Choix {

    private Saisie sc = new Saisie();

    /////////////////////////////////////////////////////////////////////////////////
    //Methodes de Choix
    //Choix de Création
    /**
     * Choix de la Classe du personnage
     *
     * @return : Personnage transtypé en la classe de personnage choisie
     */
    public Personnage choixClasse() {
        boolean continuerSaisie = true;
        int choix = 0;
        Personnage joueur = null;
        do {
            System.out.println("Veuillez choisir la classe de votre personnage (1: Guerrier, 2: Rôdeur, 3: Mage.)");
            choix = sc.saisirInt();
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

        } while (continuerSaisie);
        return joueur;
    }

    /**
     * Méthode de choix du niveau du personnage
     *
     * @param joueur : joueur à modifier
     * @return : joueur modifié
     */
    public Personnage choixNiveau(Personnage joueur) {
        Boolean continuerSaisie = true;
        do {
            System.out.println("Niveau du personnage ? (de 1 à 100)");
            try {
                joueur.setNiveau(sc.saisirInt());
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
    public Personnage choixForce(Personnage joueur, int maxPoint) {
        Boolean continuerSaisie = true;
        do {
            System.out.println("Force du personnage ?           Vous avez " + maxPoint + "points à distribuer.");
            try {
                joueur.setForce(sc.saisirInt());
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
    public Personnage choixAgilite(Personnage joueur, int maxPoint) {
        Boolean continuerSaisie = true;
        do {
            System.out.println("Agilité du personnage ?         Vous avez " + maxPoint + "points à distribuer.");
            try {
                joueur.setAgilite(sc.saisirInt());
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
    public Personnage choixInteligence(Personnage joueur, int maxPoint) {
        Boolean continuerSaisie = true;
        do {
            System.out.println("Inteligence du personnage ?     Vous avez " + maxPoint + "points à distribuer.");
            try {
                joueur.setIntelligence(sc.saisirInt());
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
    public int choixAttaque(Personnage joueur) {
        boolean continuerSaisie;
        int damage = 0;
        do {
            System.out.println(joueur.getName() + " (" + joueur.getVie() + " Vitalité) Veuillez choisir votre Action (1: Attaque de base: " + joueur.getAttaqueBasique() + "    ; 2: Attaque Spéciale: " + joueur.getAttaqueSpeciale() + ".)");
            int choix = sc.saisirInt();
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
        } while (continuerSaisie);
        return damage;
    }

    /**
     * Demande pour recommencer le combat
     * @return : true si oui; false si non
     */
    public Boolean askForReloadFight() {
        System.out.println("Voulez-vous rejouer?");
        Boolean rejouer = sc.demandeOuiNon();
        return rejouer;
    }


}
