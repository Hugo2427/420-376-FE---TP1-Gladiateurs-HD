package personnages;

import java.util.Random;

public class Retiaires extends Personnage {

    boolean hasNet;
    
    public Retiaires(String nom, int attaqueMax, int defense, int pvs, int ini, boolean hasNet) {
                this.nom = nom;
        this.pointDeVie = pvs;
        this.valeurMaxAttaque = attaqueMax;
        this.valeurDefense = defense;
        this.initiative = ini;
        this.hasNet = hasNet;
        
    }

    public Retiaires() {
                nom = "";
        pointDeVie = 0;
        valeurMaxAttaque = 0;
        valeurDefense = 0;
        initiative = 0;
        hasNet = false;
    }
    
    public void frapperPersonnage (Mirmillons personnageCible){
        int forceDeFrappe = attaqueCalcul();
        
        int dommage = forceDeFrappe - personnageCible.valeurDefense;
        
        if (dommage <= 0) {
            dommage = 0;
        }
        
        if (hasNet) {
             Random rand = new Random();
        int x = rand.nextInt(10);
            if (x == 6) {
                personnageCible.pointDeVie = 0;
                System.out.println("Le personnage a été tué par le filet");
            }
            else {
                hasNet = false;
            }
        }
        else {
            hasNet = true;
            System.out.println("Recupere son filet");
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

    private void throwNet() {
       
    }
}
