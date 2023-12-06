package repositories;

import entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
// Annotation Repository pour indiquer que c'est un repository
@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {

    //retourner la liste de toutes les comptes
    ArrayList<Compte> getAllComptes();

    //retourne le compte par id
    Compte getCompteById(Long id);

    //Creation d'une compte
    void createCompte(Compte compte);

    //Mise a jour d'une compte
    void updateCompte(Compte compte);

    //Supprimer une compte
    void deleteCompteById(Long id);
}

