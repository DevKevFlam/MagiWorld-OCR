package model;

import Exception.wrongStatInitException;

public class Rodeur extends Personnage {

    public Rodeur() {
        this.setAttaqueBasique("Tir à l’Arc");
        this.setAttaqueSpeciale("Concentration");
        this.setCatchPhrase("\nIl vaut mieux avoir plusieurs cordes à son arc qu'un cheveu sur la langue.\n");
    }

    //Méthodes
    @Override
    public int attaqueBasique() {
        int damage = this.getAgilite();
        if (damage == 0) {damage = 1; }
        System.out.println(this.getName() + ": utilise un " + this.getAttaqueBasique() + " et inflige " + damage + " dommages.");

        return damage;
    }

    @Override
    public int attaqueSpeciale() {
        try {
            if ((this.getNiveau() / 2) <= 1) {
                this.setAgilite(this.getAgilite() + 1);
            } else {
                this.setAgilite(this.getAgilite() + this.getNiveau() / 2);
            }
            System.out.println(this.getName() + ": Utilise " + this.getAttaqueSpeciale() + ", Son Agilité augmente.");
        } catch (wrongStatInitException e) {
            //max agilité
            try {
                this.setAgilite(100);
            } catch (wrongStatInitException e1) {//IMPOSSIBLE
            }
        }
        if (this.getAgilite() == 100) {
            System.out.println(this.getName() + ": Votre Agilité est au maximum (AGL: " + this.getAgilite() + " ).");
        } else {
            System.out.println(this.getName() + ": Votre Agilité à augmenter " + this.getNiveau() / 2 + ", votre agilité est actuellement à " + this.getAgilite());
        }
        return 0;
    }
}
