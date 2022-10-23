/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Categorie;
import services.CategorieService;
import services.CategorieServiceImpl;
import entities.Reclamation;
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
        
        Categorie C1 = new Categorie (4,"autre2") ;
        Categorie C2 = new Categorie (4,"autre3") ;
        CategorieService cc = new CategorieServiceImpl () ;
       
        Reclamation R1 = new Reclamation (1, 1, 1, 1, 4, "s", "text4", "ok", "08/10/2022") ;
        Reclamation R2 = new Reclamation (7, 1, 1, 4, 1, "m", "text2", "ok", "09/10/2022") ;
        Reclamation R3 = new Reclamation (5, 2, 2, 1, 4, "k", "text3", "ok", "10/10/2022") ;
        ReclamationService rc = new ReclamationServiceImpl () ;
       
       
        //cc.createCategorie(C1);
        //cc.updateCategorie(C2);
        //cc.deleteCategorie(4);
        //cc.getAll();
       
       
        //rc.createReclamation(R1);
        //rc.updateReclamation(R2);
        //rc.deleteReclamation(6);
        //rc.getAll();

    }
}
    

