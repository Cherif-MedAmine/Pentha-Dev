/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Categorie;
import java.util.List;

/**
 *
 * @author AJ
 */
public interface CategorieService {
    
    public void createCategorie(Categorie C);
    public void updateCategorie(Categorie C);
    public void deleteCategorie(int idCategorie);
    public List<Categorie> getAll();
    public Categorie getOneById(int id);
    
}
