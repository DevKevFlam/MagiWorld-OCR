package ui;

import Exception.deadException;
import model.Personnage;

public class Controller {


    private Affichage aff = new Affichage();
    private Choix choix = new Choix();

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
        Personnage joueur = choix.choixClasse();
        joueur.setName(name);
        //Niveau
        joueur = choix.choixNiveau(joueur);
        int maxPoint = joueur.getNiveau();
        //Force
        do {joueur = choix.choixForce(joueur, maxPoint);
            verifPoints = this.depasseMax(maxPoint - joueur.getForce());
        } while (verifPoints);
        maxPoint -= joueur.getForce();
        ////////////////////////////////////////////////
        //Agilité
        do {joueur = choix.choixAgilite(joueur, maxPoint);
            verifPoints = this.depasseMax(maxPoint - joueur.getAgilite());
        } while (verifPoints);
        maxPoint -= joueur.getAgilite();
        //Intelligence
        do {joueur = choix.choixInteligence(joueur, maxPoint);
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
            damage = choix.choixAttaque(joueur1);
            System.out.println(joueur2.getName() + ": Perd " + damage + " points de vie");
            try { joueur2.subitDegat(damage);
            } catch (deadException e) {
                System.out.println(e.getMessage());
                winner = joueur1;
                break;}
            //Tour Joueur2
            damage = choix.choixAttaque(joueur2);
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

        aff.afficherBonjour();
        do {
            if (rejouer) {
                aff.afficherReplay();
            }
            //Creation des personnage
            Personnage joueur1 = this.creerPersonnage("Joueur 1");
            Personnage joueur2 = this.creerPersonnage("Joueur 2");
            //FIGHT!!!!
            winner = this.combat(joueur1, joueur2);
            aff.affichageWinner(winner);
            //RECOMMENCER?
            rejouer = choix.askForReloadFight();
        } while (rejouer);
    }

}
