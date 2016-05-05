package tn.esprit.ejbinfini.services.contracts;

import javax.ejb.Remote;

import tn.esprit.ejbinfini.entities.Classe;
import tn.esprit.ejbinfini.entities.ModuleClasse;

@Remote
public interface IClasseServicesRemote {
	
	public void createClasse(Classe classe);
	
	public Classe retrieveClasseById(String id);
	
	public Classe retrieveClasseByStudentFirstName(String fName);
	
	public void createModuleClasse(ModuleClasse moduleClasse);

}
