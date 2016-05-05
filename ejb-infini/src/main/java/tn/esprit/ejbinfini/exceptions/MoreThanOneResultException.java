package tn.esprit.ejbinfini.exceptions;

import javax.ejb.ApplicationException;

/**
 * There two kind of exceptions thrown. System exceptions like EjbException,
 * RemoteException... Application exceptions are user or project custom
 * exception (like this one). An application exception shall be thrown when
 * there is a business-logic error, as opposed to a system error.
 * 
 * There is an important difference: application exceptions do not automatically
 * cause a transaction to rollback. The client has an opportunity to recover
 * after an application exception is thrown.
 * 
 * Application exceptions are sent to the client without being repackaged as an
 * EJBException. You should know that all exceptions are wrapped as EjbException
 * by the EjbContainer.Therefore, you can use them to report validation errors
 * or business logic problems, and they will reach the client.
 * 
 * Application exceptions must not extend RuntimeException or
 * RemoteException.
 * 
 * Finally you can use @ApplicationException(rollback=true) if you want the
 * transaction to be rolled back automatically.
 * 
 * @author Amine Bessrour
 *
 */
@ApplicationException(rollback=true)
public class MoreThanOneResultException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
