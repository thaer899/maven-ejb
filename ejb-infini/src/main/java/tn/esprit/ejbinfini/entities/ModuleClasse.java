package tn.esprit.ejbinfini.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 
 * The <b>"@Entity"</b> annotation specifies that the class is a JPA entity.
 * This annotation is applied to the entity class. Must be used in conjuction
 * with the <b>"@Id"</b> annotation. Either inherited from a super class or
 * defined over a primary key field
 * <p>
 * 
 * The <b>"@EmbeddedId"</b> annotation is applied to a persistent field or
 * property of an entity class or mapped superclass to denote a composite
 * primary key that is an embeddable class. The embeddable class must be
 * annotated as Embeddable. There must be only one EmbeddedId annotation and no
 * Id annotation when the EmbeddedId annotation is used. Relationship mappings
 * defined within an embedded id class are not supported.
 * <p>
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
public class ModuleClasse implements Serializable {

	private ModuleClassePK pk;
	private Classe classe;
	private Module module;

	@EmbeddedId
	public ModuleClassePK getPk() {
		return pk;
	}

	public void setPk(ModuleClassePK pk) {
		this.pk = pk;
	}

	@ManyToOne
	@JoinColumn(name = "cName", referencedColumnName = "cName", updatable = false, insertable = false)
	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	@ManyToOne
	@JoinColumn(name = "id", referencedColumnName = "id", updatable = false, insertable = false)
	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
