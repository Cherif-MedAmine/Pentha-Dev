/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Message;
import java.util.List;

/**
 *
 * @author Riadh Akkari
 */
public interface InterfaceMessage {
    public void ajouterMessage (Message M);
    public void modifierMessage (Message M);
    public void supprimerMessage (int idMessage) ;
    public List<Message> Afficher(); 
    
}
