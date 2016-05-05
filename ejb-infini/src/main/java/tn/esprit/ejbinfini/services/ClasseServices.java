package tn.esprit.ejbinfini.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.ejbinfini.entities.Classe;
import tn.esprit.ejbinfini.entities.ModuleClasse;
import tn.esprit.ejbinfini.services.contracts.IClasseServicesRemote;

/**
 * Session Bean implementation class ClasseServices
 */
@Stateless
public class ClasseServices implements IClasseServicesRemote {

	@PersistenceContext(unitName = "ejb-infini")
	EntityManager em;

	public ClasseServices() {

	}

	@Override
	public Classe retrieveClasseById(String id) {
		return em.find(Classe.class, id);
	}

	@Override
	public Classe retrieveClasseByStudentFirstName(String fName) {
		TypedQuery<Classe> query = em.createQuery(
				"select s.classe from Student s where s.fName =:fName",
				Classe.class);
		query.setParameter("fName", fName);
		return query.getSingleResult();
	}

	public Classe retrieveClasseByYear(String year) {
		Query query = em.createNamedQuery("retrieveClasseByYear");
		query.setParameter("year", year);
		return (Classe) query.getSingleResult();
	}

	@Override
	public void createClasse(Classe classe) {
		em.persist(classe);
	}
	
	@Override
	public void createModuleClasse(ModuleClasse moduleClasse){
		em.persist(moduleClasse);
	}

}
