package model;

import Exception.deadException;
import Exception.wrongStatInitException;

public abstract class Personnage {
    /**
     * Niveau du Personnage
     */
    private int niveau;
    /**
     * Vie du Personnage
     */
    private int vie;
    /**
     * Force du Personnage
     */
    private int force;
    /**
     * Agilité du Personnage
     */
    private int agilite;
    /**
     * Inteligence du Personnage
     */
    private int intelligence;

    /**
     * nom du Personnage
     */
    private String name;
    /**
     * nom de l'attaque de base
     */
    private String attaqueBasique;
    /**
     * nom de l'attaque spéciale
     */
    private String attaqueSpeciale;
    /**
     * Phrase d'accroche de Classe
     */
    private String catchPhrase;

    //Methode
    // Guetter and Setter
    /**
     * Guetter de la phrase d'accroche du Personnage
     * @return : la phrase d'accroche
     */
    public String getCatchPhrase() {
        return catchPhrase;
    }

    /**
     * Setter de la phrase d'accroche du Personnage
     * @param catchPhrase : la phrase d'accroche
     */
    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    /**
     * Guetter Nom du Personnage
     * @return le nom du Personnage
     */
    public String getName() {
        return name;
    }

    /**
     * Setter Nom du Personnage
     * @param name : Nom du Personnage
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gutter du Nom de l'attaque de base du Personnage
     * @return : Nom de l'attaque de bas du Personnage
     */
    public String getAttaqueBasique() {
        return attaqueBasique;
    }

    /**
     * Setter du Nom de l'attaque de base du Personnage
     * @param attaqueBasique : Nom de l'attaque de base du Personnage
     */
    public void setAttaqueBasique(String attaqueBasique) {
        this.attaqueBasique = attaqueBasique;
    }

    /**
     * Guetter du Nom de l'attaque spéciale du Personnage
     * @return : Nom de l'attaque spéciale du Personnage
     */
    public String getAttaqueSpeciale() {
        return attaqueSpeciale;
    }

    /**
     * Setter du Nom de l'attaque spéciale du Personnage
     * @param attaqueSpeciale : Nom de l'attaque spéciale du Personnage
     */
    public void setAttaqueSpeciale(String attaqueSpeciale) {
        this.attaqueSpeciale = attaqueSpeciale;
    }

    /**
     *  Guetter du niveau du Personnage
     * @return: niveau du Personnage
     */
    public int getNiveau() {
        return niveau;
    }

    /**
     * Setter du niveau du Personnage
     * @param niveau : niveau du Personnage
     * @throws wrongStatInitException : si niveau est "Out Of Range"
     */
    public void setNiveau(int niveau) throws wrongStatInitException {
        if (niveau >= 1 && niveau <= 100) {
            this.niveau = niveau;
            this.vie = 5 * this.niveau;
        } else {
            throw new wrongStatInitException("Le Niveau de votre personnage doit être entre 1 et 100 (compris)!");
        }
    }

    /**
     * Guetter des points de vie du Personnage
     * @return : points de vie du Personnage
     */
    public int getVie() {
        return vie;
    }

    /**
     * Setter des points de vie du Personnage
     * @param vie : points de vie du Personnage
     */
    public void setVie(int vie) {
        this.vie = vie;
        if (this.vie > 5 * this.niveau) {
            this.vie = 5 * this.niveau;
            System.out.println(this.getName() + ": Point de Vie Maximum atteint (Pv :" + 5*this.niveau + " ).");
        }

    }

    /**
     * Guetter des points de Force du Personnage
     * @return : points de Force du Personnage
     */
    public int getForce() {
        return force;
    }

    /**
     * Setter des points de Force du Personnage
     * @param force : points de Force du Personnage
     * @throws wrongStatInitException : si points de Force du Personnage est "Out Of Range"
     */
    public void setForce(int force) throws wrongStatInitException {
        if (force >= 0 && force <= 100) {
            this.force = force;
        } else {
            throw new wrongStatInitException("La Force de votre personnage doit être entre 0 et 100 (compris)!");
        }
    }

    /**
     * Guetter des points d'Agilité du Personnage
     * @return: points d'Agilité du Personnage
     */
    public int getAgilite() {
        return agilite;
    }

    /**
     * Setter des points d'Agilité du Personnage
     * @param agilite : points d'Agilité du Personnage
     * @throws wrongStatInitException : si points d'Agilité du Personnage est "Out Of Range"
     */
    public void setAgilite(int agilite) throws wrongStatInitException {

        if (agilite >= 0 && agilite <= 100) {
            this.agilite = agilite;
        } else {
            throw new wrongStatInitException("L'agilité de votre personnage doit être entre 0 et 100 (compris)!");
        }

    }

    /**
     * Guetter des points d'Intelligence du Personnage
     * @return : points d'Intelligence du Personnage
     */
    public int getIntelligence() {
        return intelligence;
    }

    /**
     * Setter des points d'Intelligence du Personnage
     * @param intelligence : points d'Intelligence du Personnage
     * @throws wrongStatInitException : si des points d'Intelligence du Personnage est "Out Of Range"
     */
    public void setIntelligence(int intelligence) throws wrongStatInitException {
        if (intelligence >= 0 && intelligence <= 100) {
            this.intelligence = intelligence;
        } else {
            throw new wrongStatInitException("L'Inteligence de votre personnage doit être entre 0 et 100 (compris)!");
        }

    }

    //Méthodes
    /**
     * Methode de perte de Point de Vie
     * @param damage : dommages infligé au personnage
     * @throws deadException : exception de si PV = 0
     */
    public void subitDegat(int damage) throws deadException {
        this.setVie(this.getVie() - damage);
        if (this.vie <= 0) {
            this.vie = 0;
            throw new deadException(this.getName() + " est mort!");}
    }

    /**
     * Attaque de base du personnage
     * @return domage infligé par l'attaque
     */
    public abstract int attaqueBasique();

    /**
     * Attaque de spéciale du personnage
     * @return domage infligé par l'attaque
     */
    public abstract int attaqueSpeciale();

}
