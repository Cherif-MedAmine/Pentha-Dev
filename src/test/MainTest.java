/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Categorie;
import entities.Discussion;
import entities.Message;
import services.CategorieService;
import services.CategorieServiceImpl;
import entities.Reclamation;
import services.DiscussionCRUD;
import services.MessageCRUD;
import services.ReclamationService;
import services.ReclamationServiceImpl;
import utils.MyDB;

/**
 *
 * @author AJ
 */
public class MainTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyDB.getInstance();
    
       MyDB c = MyDB.getInstance() ;
       
       Message M1 = new Message (5,8, 1 ,"ria","helmi" );
        //Message M2 = new Message (2,3,4,"salah","jebalia");
        MessageCRUD MC = new MessageCRUD();
        
        Discussion D1 = new Discussion (8, 5 , 1);
        DiscussionCRUD DC = new DiscussionCRUD () ;
        
        //MC.ajouterMessage(M1); 
        //MC.modifierMessage(M1);
        //MC.supprimerMessage(5);
        //MC.Afficher().forEach(System.out::println);
        
        //DC.ajouterDiscussion(D1);
        //DC.modifierDiscussion(D1);
         //DC.supprimerDiscussion(1);
        //DC.Afficher().forEach(System.out::println);
        
        
       Categorie C1 = new Categorie (1,"annonce") ;
       Categorie C2 = new Categorie (4,"autre3") ;
       CategorieService cc = new CategorieServiceImpl () ;
       
       Reclamation R1 = new Reclamation (1, 1, 1, 1, 4, "o", "text1", "ok") ;
       Reclamation R2 = new Reclamation (2, 1, 1, 4, 1, "m", "text4", "not ok") ;
       Reclamation R3 = new Reclamation (5, 2, 2, 1, 4, "k", "text3", "ok") ;
       //Reclamation R2 = new Reclamation (2,3 , "Faux annonce") ;
       //Reclamation R3 = new Reclamation (4,3 , "Prix gonflé") ;
       ReclamationService rc = new ReclamationServiceImpl () ;
       
       
       //cc.createCategorie(C1);
       //cc.updateCategorie(C2);
       //cc.deleteCategorie(4);
       //cc.getAll();
       
       
       rc.createReclamation(R2); 
       //rc.updateReclamation(R3);
       //rc.deleteReclamation(4);
       //rc.getAll();

    }
}
    

