package web;

import entities.Compte;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.CompteRepository;

import java.util.ArrayList;


@Path("/Comptes")
public class CompteRestJaxRSAPI {

    @Autowired
    // Injection de dépendance pour CompteRepository
    private CompteRepository compteRepository;

    // Récupère une liste de tous les comptes
    @GET
    @Path("/Comptes")
    @Transactional
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ArrayList<Compte> compteList() {
        return compteRepository.getAllComptes();
    }

    // Récupère un compte spécifique par son ID
    @GET
    @Path("/Comptes/{id}")
    public Compte getOne(@PathParam("id") Long id) {
        return compteRepository.getCompteById(id);
    }

    // Crée un nouveau compte
    @POST
    @Path("/Comptes")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public void save(Compte compte) {
        compteRepository.createCompte(compte);
    }

    // Met à jour un compte existant par son ID
    @PUT
    @Path("/Comptes/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public void update(Compte compte, @PathParam("id") Long id) {
        compte.setId(id);
        compteRepository.updateCompte(compte);
    }

    // Supprime un compte par son ID
    @DELETE
    @Path("/comptes/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public void delete(@PathParam("id") Long id) {
        compteRepository.deleteCompteById(id);
    }

    public void setCompteRepository(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }
}



