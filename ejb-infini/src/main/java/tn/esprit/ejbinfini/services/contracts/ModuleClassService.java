package tn.esprit.ejbinfini.services.contracts;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.ejbinfini.entities.ModuleClasse;
@Stateless
public class ModuleClassService implements ImoduleClass {
	@PersistenceContext(unitName = "ejb-infini-postgres")
	private EntityManager em2;
	
	@PersistenceContext(unitName = "ejb-infini")
	private EntityManager em;
	@Override
	public void createModuleClass(ModuleClasse mc) {
		// TODO Auto-generated method stub
		em.persist(mc);
	}

}
