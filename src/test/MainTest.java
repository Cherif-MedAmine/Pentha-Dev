/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Annonce;
import services.AnnonceCRUD;
import utils.MyDB; 
import entities.Attachement;
/**
 *
 * @author amine
 */
public class MainTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           MyDB c = MyDB.getInstance() ;
        
       // Annonce A1 = new Annonce (1,"jss" , "nfnf","nfnf", (float) 5.3,"nfnf","nfnf",6,"nfnf","nfnf","nfnf","nfnf","nfnf","nfnf") ;
        Annonce A3 = new Annonce (3 ,4, "ahmed,","riadh", (float) 1.3,"amir","ofjvljglqd",6,"flf","232d","mariam","nfnf","jsjd","nfnf",0) ;
         Attachement Att1 = new Attachement (2 ,3, "amine,","riadh","amir");
        AnnonceCRUD cc = new AnnonceCRUD () ;
        
        cc.ajouterAttachement(Att1); 
       // cc.modifierAttachement(Att1);
        //cc.supprimerAttachement(1);
          
       // cc.AfficherAtt().forEach(System.out::println);
        /////////////////////////////////////
       // cc.ajouterAnnonce(A3);
        //cc.supprimerAnnonce(A3);
       // cc.modifierAnnonce(A3);
         
      // cc.Afficher().forEach(System.out::println);
    }

}
    


