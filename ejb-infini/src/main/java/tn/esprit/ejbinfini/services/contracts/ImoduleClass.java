package tn.esprit.ejbinfini.services.contracts;

import javax.ejb.Remote;

import tn.esprit.ejbinfini.entities.ModuleClasse;
@Remote
public interface ImoduleClass {
	public void createModuleClass(ModuleClasse mc);
	

}
