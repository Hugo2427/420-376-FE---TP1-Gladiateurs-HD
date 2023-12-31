package jeugladiateurs;

import personnages.Personnage;
import combat.CompteurDeTour;
import combat.AffichageEcran;
import personnages.Mirmillons;
import personnages.Retiaires;

public class JeuGladiateurs {

    public static void main(String[] args) {

    // **************************************************************************
    // **************************************************************************
    // **************************************************************************
    // <editor-fold defaultstate="expanded" desc="Instanciation des objets">
    CompteurDeTour tour = new CompteurDeTour();
    AffichageEcran affichage = new AffichageEcran();
    Mirmillons Bob = new Mirmillons("Bob le malchanceux", 15, 15, 70, 15);
    Retiaires Igor = new Retiaires("Igor l'empaleur", 25, 5, 100, 30, true);
    // </editor-fold>

    // **************************************************************************
    // **************************************************************************
    // **************************************************************************
    // <editor-fold defaultstate="collapsed" desc="Affichage pré-combat">
    // TODO : Afficher les infos de chaque personnage
    Bob.afficherInfosPersonnage();
    Igor.afficherInfosPersonnage();
    
    
    affichage.afficherDebutCombat();
    
    while ((Bob.getPointDeVie() > 0) && (Igor.getPointDeVie() > 0)) {
        
    tour.afficheTour();
    
    for (int i = 0; i < 100; i++) {
        if (i == Bob.getInitiative()) {
            Bob.frapperPersonnage(Igor);
            Igor.frapperPersonnage(Bob);
            break;
        }
        else if (i == Igor.getInitiative()) {
            Igor.frapperPersonnage(Bob);
            Bob.frapperPersonnage(Igor);
            break;
        }
    }
    affichage.afficherSeparateurInfosPerso();
    Bob.afficherInfosPersonnage();
    affichage.afficherSeparateurInfosPerso();
    Igor.afficherInfosPersonnage();
    
    Bob.setNewInitiativeRandom();
    Igor.setNewInitiativeRandom();
    tour.augmenteTour();
    affichage.afficherSeparateurDeTour();
    }
    
    affichage.afficheVictoire(Bob, Igor);
    // ************************ Debut du code temporaire ***********************

    // ************************ Fin du code temporaire ***********************




// TODO : Afficher le message du début du combat
    // </editor-fold>

    // **************************************************************************
    // **************************************************************************
    // **************************************************************************
    // <editor-fold defaultstate="collapsed" desc="Mécanique de combat">
    // TODO : La boucle contenant les étapes du combat
    // TODO : Après la boucle, afficher le résultat du combat
    // </editor-fold>
    }

}
