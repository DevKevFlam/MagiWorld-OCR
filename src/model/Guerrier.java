package model;

public class Guerrier extends Personnage {

    public Guerrier() {
        this.setAttaqueBasique("Coup d’Épée");
        this.setAttaqueSpeciale("Coup de Rage");
        this.setCatchPhrase("\nLEEROOOOOOOOOOOOOOOOOOOOOOY JEEEEEEENKIIIIIIIIIIIIIIINS!!!!\n");
    }

    //Méthodes

    /**
     * Méthode pour calculer les Pv restant du guerrier lors du coup de Rage
     *
     * @param damages: dommage subit
     * @return : Points de vie apres dommages
     */
    public int vieAfterDamage(int damages) {
        if (damages <= 1) {
            damages = 1;
        }
        int vie = this.getVie() - damages;
        return vie;
    }

    @Override
    public int attaqueBasique() {
        int damage = this.getForce();
        if (damage == 0) {
            damage = 1;
        }
        System.out.println(this.getName() + " utilise un " + this.getAttaqueBasique() + " et inflige " + damage + " dommages.");
        return damage;
    }

    @Override
    public int attaqueSpeciale() {
        int damage;
        if (this.getForce() == 0) {
            damage = 2;
            System.out.println(this.getName() + " utilise un " + this.getAttaqueSpeciale() + " et inflige " + damage + " dommages.");
            this.setVie(this.vieAfterDamage(1));
            System.out.println(this.getName() + " S'inflige " + 1 + " points de vie.");
        } else {
            damage = this.getForce() * 2;
            System.out.println(this.getName() + " utilise un " + this.getAttaqueSpeciale() + " et inflige " + damage + " dommages.");
            this.setVie(this.vieAfterDamage(this.getForce() / 2));
            System.out.println(this.getName() + " S'inflige " + this.getForce() / 2 + " points de vie.");
        }
        return damage;
    }
}
