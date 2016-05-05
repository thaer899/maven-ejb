package tn.esprit.ejbinfini.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * The <b>"@Entity"</b> annotation specifies that the class is a JPA entity.
 * This annotation is applied to the entity class. Must be used in conjuction
 * with the <b>"@Id"</b> annotation. Either inherited from a super class or
 * defined over a primary key field
 * <p>
 * 
 * The <b>"@ManyToOne"</b> annotation specifies a single-valued association to
 * another entity class that has many-to-one multiplicity. It is not normally
 * necessary to specify the target entity explicitly since it can usually be
 * inferred from the type of the object being referenced. If the relationship is
 * bidirectional, the non-owning OneToMany entity side must used the mappedBy
 * element to specify the relationship field or property of the entity that is
 * the owner of the relationship.
 * 
 * @author Amine Bessrour
 *
 */

@Entity
public class Student extends Person implements Serializable {

	private String password;
	private Boolean hasDiploma;
	private Classe classe;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getHasDiploma() {
		return hasDiploma;
	}

	public void setHasDiploma(Boolean hasDiploma) {
		this.hasDiploma = hasDiploma;
	}

	@ManyToOne(cascade = CascadeType.PERSIST)
	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Student(String fName, String lName, Date birthDate, String email,
			String password, Boolean hasDiploma, Classe classe) {
		super(fName, lName, birthDate, email);
		this.password = password;
		this.hasDiploma = hasDiploma;
		this.classe = classe;
	}

	public Student() {
		super();
	}

	private static final long serialVersionUID = 1L;

}
