/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Discussion;
import java.util.List;

/**
 *
 * @author Riadh Akkari
 */
interface InterfaceDiscussion {
    public void ajouterDiscussion (Discussion D);
    public void modifierDiscussion (Discussion D);
    public void supprimerDiscussion (int idDiscussion) ;
    public List<Discussion> Afficher(); 
    
}
