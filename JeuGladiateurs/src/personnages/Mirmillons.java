package personnages;

import java.util.Random;

public class Mirmillons extends Personnage {

    public Mirmillons(String nom, int attaqueMax, int defense, int pvs, int ini) {
        this.nom = nom;
        this.pointDeVie = pvs;
        this.valeurMaxAttaque = attaqueMax;
        this.valeurDefense = defense;
        this.initiative = ini;
    }

    public Mirmillons() {
        nom = "";
        pointDeVie = 0;
        valeurMaxAttaque = 0;
        valeurDefense = 0;
        initiative = 0;
    }
    
    @Override
    public void setNewInitiativeRandom() {
        Random rand = new Random();
        initiative = rand.nextInt(30);
    }
    
    
    
    @Override
    public void frapperPersonnage(Personnage personnageCible) {
        int forceDeFrappe = attaqueCalcul();
        
        int dommage = forceDeFrappe - personnageCible.valeurDefense;
        
        if (dommage <= 0) {
            dommage = 0;
        }
    
        personnageCible.pointDeVie = personnageCible.pointDeVie - dommage;
        
        if (personnageCible.pointDeVie <= 0) {
            personnageCible.pointDeVie = 0;
        }
        
        System.out.println("");
        System.out.println(nom + " attaque avec une puissance de : " + forceDeFrappe);
        System.out.println(personnageCible.nom + " a une defense de " + personnageCible.valeurDefense);
        System.out.println("Les dommages sont donc de " + dommage);
        
        
    }

    private int attaqueCalcul() {
        Random rand = new Random();
        int x = rand.nextInt(valeurMaxAttaque);
        return x;
    }
    
}
