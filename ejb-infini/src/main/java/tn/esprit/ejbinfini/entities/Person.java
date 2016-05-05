package tn.esprit.ejbinfini.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * 
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
 * <p>
 * 
 * The <b>"@Inheritance"</b> annotation specifies the inheritance strategy to be
 * used for an entity class hierarchy. It is specified on the entity class that
 * is the root of the entity class hierarchy. If the Inheritance annotation is
 * not specified or if no inheritance type is specified for an entity class
 * hierarchy, the SINGLE_TABLE mapping strategy is used.
 * <p>
 * 
 * <b>"Strategy"</b> is an attribute of the <b>"@Inheritance"</b> annotation.
 * Takes a <b>"InheritanceType"</b> value and defines inheritance strategy
 * options.
 * 
 * <ul>
 * <li><b>JOINED</b> A strategy in which fields that are specific to a subclass
 * are mapped to a separate table than the fields that are common to the parent
 * class, and a join is performed to instantiate the subclass.</li>
 * <li><b>SINGLE_TABLE</b> A single table per class hierarchy.</li>
 * <li><b>TABLE_PER_CLASS</b> A table per concrete entity class.</li>
 * </ul>
 * <p>
 * 
 * The <b>"@Embedded"</b> annotation specifies a persistent field or property of
 * an entity whose value is an instance of an embeddable class. The embeddable
 * class must be annotated as Embeddable.
 * 
 * @author Amine Bessrour
 *
 */

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person implements Serializable {

	private Integer id;
	private String fName;
	private String lName;
	private Date birthDate;
	private String email;
	private Address address;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Embedded
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Person() {
		super();
	}

	public Person(String fName, String lName, Date birthDate, String email) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.birthDate = birthDate;
		this.email = email;
	}

	private static final long serialVersionUID = 1L;

}
