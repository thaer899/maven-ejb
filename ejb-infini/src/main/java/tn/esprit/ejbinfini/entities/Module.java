package tn.esprit.ejbinfini.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * The <b>"@GeneratedValue"</b> annotation provides strategies for generating
 * values of primary keys. The GeneratedValue annotation may be applied to a
 * primary key property or field of an entity or mapped superclass <b>in
 * conjunction with</b> the Id annotation. The use of the GeneratedValue
 * annotation is only required to be supported for simple primary keys. Use of
 * the GeneratedValue annotation is not supported for derived primary keys.
 * <p>
 * 
 * <b>"Strategy"</b> is an attribute of the <b>"@GeneratedValue"</b>. Takes a
 * <b>"GenerationType"</b> value and defines the types of primary key generation
 * strategies.
 * 
 * <ul>
 * <li><b>AUTO</b> Indicates that the persistence provider should pick an
 * appropriate strategy for the particular database.</li>
 * <li><b>IDENTITY</b> Indicates that the persistence provider must assign
 * primary keys for the entity using a database identity column. <b>Not
 * supported by Oracle. RDBMS is responsible of Id allocation</b></li>
 * <li><b>SEQUENCE</b> Indicates that the persistence provider must assign
 * primary keys for the entity using a database sequence. <b>The most efficient
 * but the least portable</b></li>
 * <li><b>TABLE</b> Indicates that the persistence provider must assign primary
 * keys for the entity using an underlying database table to ensure uniqueness.
 * <b>The most portable. Good performance</b></li>
 * </ul>
 * 
 * The <b>"@OneToMany"</b> annotation specifies a many-valued association with
 * one-to-many multiplicity. If the relationship is bidirectional, the mappedBy
 * element must be used to specify the relationship field or property of the
 * entity that is the owner of the relationship.
 * <p>
 * 
 * 
 * The <b>"@ManyToOne"</b> annotation specifies a single-valued association to
 * another entity class that has many-to-one multiplicity. It is not normally
 * necessary to specify the target entity explicitly since it can usually be
 * inferred from the type of the object being referenced. If the relationship is
 * bidirectional, the non-owning OneToMany entity side must used the mappedBy
 * element to specify the relationship field or property of the entity that is
 * the owner of the relationship.
 * <p>
 * 
 * The <b>"@JoinColumn"</b> annotation specifies a column for joining an entity
 * association.
 * 
 * @author Amine Bessrour
 *
 */

@Entity
public class Module implements Serializable {

	private Integer id;
	private String title;
	private String description;
	private Teacher teacher;
	private List<ModuleClasse> moduleClasses;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne
	@JoinColumn(name = "id_teacher")
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@OneToMany(mappedBy = "module")
	public List<ModuleClasse> getModuleClasses() {
		return moduleClasses;
	}

	public void setModuleClasses(List<ModuleClasse> moduleClasses) {
		this.moduleClasses = moduleClasses;
	}
	
	public Module(String title, String description, Teacher teacher,
			List<ModuleClasse> moduleClasses) {
		super();
		this.title = title;
		this.description = description;
		this.teacher = teacher;
		this.moduleClasses = moduleClasses;
	}

	public Module() {
		super();
	}



	private static final long serialVersionUID = 1L;

}
