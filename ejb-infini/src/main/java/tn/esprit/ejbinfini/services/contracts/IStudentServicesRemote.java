package tn.esprit.ejbinfini.services.contracts;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.ejbinfini.entities.Student;
import tn.esprit.ejbinfini.exceptions.MoreThanOneResultException;

@Remote
public interface IStudentServicesRemote {

	public void createStudent(Student student);

	public void updateStudent(Student student);

	public void deleteStudent(Student student);

	public void deleteStudent(Integer id);

	public Student retrieveStudent(Integer id);

	public Student retrieveStudentByEmailAndPassword(String email,
			String password) throws MoreThanOneResultException;

	public Student retrieveStudentByFirstName(String fName)
			throws MoreThanOneResultException;

	public List<Student> retrieveAllStudents();

}
