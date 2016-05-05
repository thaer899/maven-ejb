package tn.esprit.ejbinfini.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.ejbinfini.entities.Student;
import tn.esprit.ejbinfini.exceptions.MoreThanOneResultException;
import tn.esprit.ejbinfini.services.contracts.IStudentServicesLocal;
import tn.esprit.ejbinfini.services.contracts.IStudentServicesRemote;

@Stateless
public class StudentServices implements IStudentServicesRemote,
		IStudentServicesLocal {

	@PersistenceContext(unitName = "ejb-infini-postgres")
	private EntityManager em2;

	@PersistenceContext(unitName = "ejb-infini")
	private EntityManager em;

	/**
	 * This service adds a student considered as new to the peristence context.
	 * Note that persist doesn't add the student to the database. The entity
	 * manager rather stores it as managed or attached to the active persistence
	 * context
	 * 
	 */
	@Override
	public void createStudent(Student student) {
		em.persist(student);
	}

	/**
	 * This service adds a student to the peristence context. Merge doesn't
	 * insert/update the student into the database. The entity manager rather
	 * stores it as managed or attached to the active persistence context. When
	 * the entity manager comes to flush it synchronizes with the database
	 * 
	 */
	@Override
	public void updateStudent(Student student) {
		em.merge(student);
	}

	/**
	 * This service marks a student being managed in the active peristence
	 * context as removed. Thus, delete doesn't remove the student from the
	 * database. When the entity manager comes to flush it synchronizes with the
	 * database. If the entity is in context and labeled as "removed", it will
	 * be then removed form the database.
	 * 
	 * N.B Can't mark as "removed" an entity not attached to the context.
	 * 
	 */
	@Override
	public void deleteStudent(Student student) {
		em.remove(em.find(Student.class, student.getId()));
	}

	/**
	 * This service marks a student being managed in the active peristence
	 * context as removed. Thus, delete doesn't remove the student from the
	 * database. When the entity manager comes to flush it synchronizes with the
	 * database. If the entity is in context and labeled as "removed", it will
	 * be then removed form the database.
	 * 
	 * N.B Can't mark as "removed" an entity not attached to the context.
	 * 
	 */
	@Override
	public void deleteStudent(Integer id) {
		em.remove(em.find(Student.class, id));
	}

	/**
	 * This service fetchs by id a student from the database and puts it in the
	 * active peristence context.
	 * 
	 * N.B Can't mark as "removed" an entity not attached to the context.
	 * 
	 */
	@Override
	public Student retrieveStudent(Integer id) {
		return em.find(Student.class, id);
	}

	/**
	 * This services uses JPQL to ask the entity manager to fetch a student by
	 * fName. JPQL stands for JPA Query Language and is build upon SQL. It
	 * questions JPA Entity rather than the database itself.
	 * 
	 * Below a TypedQuery is used rather than raw JPQL query or Native SQL
	 * query. The entity manager instanciates the query object via
	 * "em.createQuery" and the query string. A parameter is added via
	 * "query.setParameter". Finally result fetching can be tuned via the object
	 * query. Below we are expecting a unique result. Thus we're using
	 * "getSingleResult" which returns the unique result, null if any or an
	 * exception if more than one.
	 * 
	 */
	@Override
	public Student retrieveStudentByFirstName(String fName)
			throws MoreThanOneResultException {
		TypedQuery<Student> query = em.createQuery(
				"select s from Student s where s.fName =:fName", Student.class);
		query.setParameter("fName", fName);
		try {
			return query.getSingleResult();
		} catch (NonUniqueResultException e) {
			throw new MoreThanOneResultException();
		}
	}

	/**
	 * This services uses JPQL to ask the entity manager to fetch a student by
	 * fName. JPQL stands for JPA Query Language and is build upon SQL. It
	 * questions JPA Entity rather than the database itself.
	 * 
	 * Below a TypedQuery is used rather than raw JPQL query or Native SQL
	 * query. The entity manager instanciates the query object via
	 * "em.createQuery" and the query string. A parameter is added via
	 * "query.setParameter". Finally result fetching can be tuned via the object
	 * query. Below we are fetch the whole resultSet.
	 */
	@Override
	public List<Student> retrieveAllStudents() {
		TypedQuery<Student> query = em.createQuery("select s from Student s",
				Student.class);
		return query.getResultList();
	}

	@Override
	public Student retrieveStudentByEmailAndPassword(String email,
			String password) throws MoreThanOneResultException {
		TypedQuery<Student> query = em
				.createQuery(
						"select s from Student s where s.email =:email and s.password =:password",
						Student.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		try {
			return query.getSingleResult();
		} catch (NonUniqueResultException e) {
			throw new MoreThanOneResultException();
		} catch (NoResultException e) {
			throw new MoreThanOneResultException();
		}
	}

}
