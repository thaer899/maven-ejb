package tn.esprit.ejbinfini.services.contracts;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.ejbinfini.entities.Classe;
import tn.esprit.ejbinfini.entities.Module;
@Stateless
public class ModuleServices implements ImoduleServiceServiceRemote{
	@PersistenceContext(unitName = "ejb-infini-postgres")
	private EntityManager em2;
	
	@PersistenceContext(unitName = "ejb-infini")
	private EntityManager em;

	@Override
	public void createModule(Module module) {
		// TODO Auto-generated method stub
		em.persist(module);
	}

	@Override
	public void removeModule(Module module) {
		// TODO Auto-generated method stub
		em.remove(em.merge(module));
	}
	@Override
	public Module retrieveModuleById(Integer id) {
		return em.find(Module.class, id);
	}


}
