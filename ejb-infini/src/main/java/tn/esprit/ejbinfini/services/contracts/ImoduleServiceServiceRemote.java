package tn.esprit.ejbinfini.services.contracts;

import javax.ejb.Remote;

import tn.esprit.ejbinfini.entities.Module;
@Remote
public interface ImoduleServiceServiceRemote {
public void createModule(Module module);
public void removeModule(Module module);
public Module retrieveModuleById(Integer id);
}
