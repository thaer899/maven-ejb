package tn.esprit.ejbinfini.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * The <b>"@Entity"</b> annotation specifies that the class is a JPA entity.
 * This annotation is applied to the entity class. Must be used in conjuction
 * with the <b>"@Id"</b> annotation. Either inherited from a super class or
 * defined over a primary key field
 * <p>
 * 
 * The <b>"@Id"</b> annotation specifies the primary key of an entity. The field
 * or property to which the Id annotation is applied should be one of the
 * following types: any Java primitive type; any primitive wrapper type; String;
 * java.util.Date; java.sql.Date; java.math.BigDecimal; java.math.BigInteger.
 * The mapped column for the primary key of the entity is assumed to be the
 * primary key of the primary table.
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
@NamedQueries({
		@NamedQuery(name = "retrieveClasseByYear", query = "select c from Classe c where c.year =:year"),
		@NamedQuery(name = "retrieveClasseByStudentFirstName", query = "select s.classe from Student s where s.fName =:fName") })
public class Classe implements Serializable {

	private String cName;
	private String year;
	private Option options;
	private List<Student> students;
	private List<ModuleClasse> moduleClasses;

	@Id
	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Option getOptions() {
		return options;
	}

	public void setOptions(Option options) {
		this.options = options;
	}

	@OneToMany(mappedBy = "classe", fetch = FetchType.EAGER)
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@OneToMany(mappedBy = "classe")
	public List<ModuleClasse> getModuleClasses() {
		return moduleClasses;
	}

	public void setModuleClasses(List<ModuleClasse> moduleClasses) {
		this.moduleClasses = moduleClasses;
	}

	public Classe(String cName, String year, Option options) {
		super();
		this.cName = cName;
		this.year = year;
		this.options = options;
	}

	public Classe(String cName, String year, Option options,
			List<Student> students) {
		super();
		this.cName = cName;
		this.year = year;
		this.options = options;
		this.students = students;
	}

	public Classe() {
		super();
	}

	public Classe(String cName, String year, Option options,
			List<Student> students, List<ModuleClasse> moduleClasses) {
		super();
		this.cName = cName;
		this.year = year;
		this.options = options;
		this.students = students;
		this.moduleClasses = moduleClasses;
	}

	private static final long serialVersionUID = 1L;
}
