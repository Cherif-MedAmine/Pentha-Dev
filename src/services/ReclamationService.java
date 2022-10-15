/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Reclamation;
import java.util.List;

/**
 *
 * @author AJ
 */
public interface ReclamationService {
    
    public void createReclamation(Reclamation R);
    public void updateReclamation(Reclamation R);
    public void deleteReclamation(int idReclamation);
    public List<Reclamation> getAll();
    //public Reclamation getOneById(int idRcalmation);
    //public List<Reclamation> getAllBySender(int idUserSRec);
    
}
