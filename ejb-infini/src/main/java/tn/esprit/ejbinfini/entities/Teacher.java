package tn.esprit.ejbinfini.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * The <b>"@Entity"</b> annotation specifies that the class is a JPA entity.
 * This annotation is applied to the entity class. Must be used in conjuction
 * with the <b>"@Id"</b> annotation. Either inherited from a super class or
 * defined over a primary key field
 * <p>
 * 
 * The <b>"@OneToMany"</b> annotation specifies a many-valued association with
 * one-to-many multiplicity. If the relationship is bidirectional, the mappedBy
 * element must be used to specify the relationship field or property of the
 * entity that is the owner of the relationship.
 * 
 * @author Amine Bessrour
 *
 */
@Entity
public class Teacher extends Person implements Serializable {

	private Date hireDate;
	private List<Module> modules;

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	@OneToMany(mappedBy="teacher")
	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public Teacher(String fName, String lName, Date birthDate, String email,
			Date hireDate) {
		super(fName, lName, birthDate, email);
		this.hireDate = hireDate;
	}

	public Teacher() {
		super();
	}

	private static final long serialVersionUID = 1L;

}
