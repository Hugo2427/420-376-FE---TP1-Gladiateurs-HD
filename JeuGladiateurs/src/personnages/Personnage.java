package personnages;
import java.util.Random;

public class Personnage {

    // **************************************************************************
    // **************************************************************************
    // **************************************************************************
    // <editor-fold defaultstate="collapsed" desc="Attributs">
    String nom;
    int pointDeVie;
    int valeurMaxAttaque;
    int valeurDefense;
    int initiative;
    // </editor-fold>

    // **************************************************************************
    // **************************************************************************
    // **************************************************************************
    // <editor-fold defaultstate="collapsed" desc="Constructeurs et initialisation">
    public Personnage(String nom, int attaqueMax, int defense, int pvs, int ini) {
        // TODO : Constructeur AVEC paramètres
        this.nom = nom;
        this.pointDeVie = pvs;
        this.valeurMaxAttaque = attaqueMax;
        this.valeurDefense = defense;
        this.initiative = ini;
    }

    public Personnage() {
        // TODO : Constructeur SANS paramètres qui initialise à ZÉRO ou à ""
        nom = "";
        pointDeVie = 0;
        valeurMaxAttaque = 0;
        valeurDefense = 0;
        initiative = 0;
    }
    // </editor-fold>
    public String getNom() {
        return nom;
        // TODO : Afficher les infos du personnage, tel que montré dans l'énoncé
    }

    public int getPointDeVie() {
        return pointDeVie;
    }

    public int getValeurMaxAttaque() {
        return valeurMaxAttaque;
    }

    public int getValeurDefense() {
        return valeurDefense;
    }

    // **************************************************************************
    // **************************************************************************
    // **************************************************************************
    // <editor-fold defaultstate="collapsed" desc="Getters et setters">
    // TODO : Les getters
    public int getInitiative() {    
        return initiative;
    }
    public void setNom(String nom) {
        this.nom = nom;
        // TODO : Afficher les infos du personnage, tel que montré dans l'énoncé
    }

    public void setPointDeVie(int pointDeVie) {
        this.pointDeVie = pointDeVie;
    }

    public void setValeurMaxAttaque(int valeurMaxAttaque) {
        this.valeurMaxAttaque = valeurMaxAttaque;
    }

    public void setValeurDefense(int valeurDefense) {
        this.valeurDefense = valeurDefense;
    }

    // TODO : Les setters
    public void setInitiative(int initiative) {    
        this.initiative = initiative;
    }

    // </editor-fold>
    // **************************************************************************
    // **************************************************************************
    // **************************************************************************
    // <editor-fold defaultstate="collapsed" desc="Mécanique de jeu">
    public void afficherInfosPersonnage() {
        // TODO : Afficher les infos du personnage, tel que montré dans l'énoncé
        System.out.println("");
        System.out.println("nom : " + nom);
        System.out.println("attaque : " + valeurMaxAttaque);
        System.out.println("Defense : " + valeurDefense);
        System.out.println("Points de vie : " + pointDeVie);
        System.out.println("Initiative : " + initiative);
        if (pointDeVie <= 0) {
            System.out.println("Statut : Mort");
        }
        else{
            System.out.println("Statut : Vivant");
        }
    }

    private int attaqueCalcul() {
        // TODO : Retourner la valeur de l'attaque du personnage.
        // Cette valeur est trouvée aléatoirement et doit se situer entre ZÉRO et valeurMaxAttaque.
        Random rand = new Random();
        int x = rand.nextInt(valeurMaxAttaque);
        return x;
    }

    public void frapperPersonnage(Personnage personnageCible) {
        // TODO : Récupérer la valeur d'attaque pour ce tour, calculer les dégats,
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
        
        
        //modifier les points de vie du personnage cible, afficher les détails
        // sur l'attaque, tel que montré dans l'énoncé.
    }

    public void setNewInitiativeRandom() {
        // TODO : Modifier de façon aléatoire la valeur INI du personnage.
        Random rand = new Random();
        initiative = rand.nextInt(100);
        
    }
    // </editor-fold>
}
