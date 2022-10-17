/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Attachement;
import entities.Annonce;
import java.util.List;

/**
 *
 * @author amine
 */
public interface InterfaceAnnonce {
      public void ajouterAnnonce (Annonce A) ;
    public void modifierAnnonce(Annonce A) ;
    public void supprimerAnnonce(Annonce A) ;
    public List<Annonce> Afficher() ; 
     public void ajouterAttachement (Attachement Att) ;
    public void modifierAttachement(Attachement Att) ;
    public void supprimerAttachement(int Att) ;
    public List<Attachement> AfficherAtt() ;
    
    
}
