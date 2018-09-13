package model;

public class Mage extends Personnage {

    public Mage() {
        this.setAttaqueBasique("Boule de Feu");
        this.setAttaqueSpeciale("Soin");
        this.setCatchPhrase("\n Ah ben j’suis mi-démon, moi, les démons c’est pas foutu pareil. D’ailleurs, dans le calendrier démonique je vais bientôt avoir sept ans. \nJ’aurai le droit d’avoir une mogriave. C'est quoi une mogriave ? Bas c’est comme un petit chien, mais hyper vilain.\n");
    }

    //Méthodes
    /**
     * Méthode pour calculer les Pv du Mage apres soins
     * @param soins: Soins subit
     * @return : Points de vie apres soins
     */
    public int soin(int soins){
        if (soins <= 1){soins = 1; }
        int vie = this.getVie() + soins;
        return vie;
    }

    public int attaqueBasique() {
        int damage = this.getIntelligence();
        if (damage == 0) { damage = 1; }
        System.out.println(this.getName() + " utilise une " + this.getAttaqueBasique() + " et inflige " + damage + " dommages.");
        return damage;
    }

    public int attaqueSpeciale() {
        if(this.getIntelligence()==0){
            System.out.println(this.getName() + ": utilise " + this.getAttaqueSpeciale() + " et gagne " + 1 + " point de vie.");
            this.setVie(this.soin(1));
        }else{
        System.out.println(this.getName() + ": utilise " + this.getAttaqueSpeciale() + " et gagne " + 2 * this.getIntelligence() + " point de vie.");
        this.setVie(this.soin(2 * this.getIntelligence()));}
        return 0;
    }
}
