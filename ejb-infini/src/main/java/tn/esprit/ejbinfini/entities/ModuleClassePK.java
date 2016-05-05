package tn.esprit.ejbinfini.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * 
 * The <b>"@Embeddable"</b> annotation specifies a class whose instances are stored as a part
 * of an owning entity and share the identity of the entity. No need to declare
 * an id into an embeddable class. Each of the persistent properties or fields
 * of the embedded object is mapped to the database table for the entity. Note
 * that the Transient annotation may be used to designate the non-persistent
 * state of an embeddable class.
 * <p>
 * 
 * @author Amine Bessrour
 *
 */

@Embeddable
public class ModuleClassePK implements Serializable {

	private String cName;
	private Integer id;

	public ModuleClassePK() {
		super();
	}

	public ModuleClassePK(String cName, Integer id) {
		super();
		this.cName = cName;
		this.id = id;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cName == null) ? 0 : cName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModuleClassePK other = (ModuleClassePK) obj;
		if (cName == null) {
			if (other.cName != null)
				return false;
		} else if (!cName.equals(other.cName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	private static final long serialVersionUID = 1L;

}
