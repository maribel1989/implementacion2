package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import org.hibernate.criterion.Order;

import co.edu.udea.iw.dao.DependenciaDAO;
import co.edu.udea.iw.dto.Dependencia;
import co.edu.udea.iw.exception.MyException;

/**
 * Implementaci�n de DependenciaDAO
 * 
 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 */
public class DependenciaDAOHibernate implements DependenciaDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// Metodo para crear una lista de Dependencias
	@Override
	public List<Dependencia> get() throws MyException {

		// Creaci�n de sesion a la base de datos
		Session session = null;
		Criteria criteria = null;
		List<Dependencia> dependencia = new ArrayList<Dependencia>();

		try {
			// Obtengo sesion a la base de datos
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(Dependencia.class);

			// Para ver la lista por orden de nombre
			// criteria.addOrder(Order.asc("id"));

			dependencia = criteria.list();
		} catch (HibernateException e) {
			throw new MyException("Se encontraron errores consultando las dependencias", e);
		} finally {
			// if(session != null){
			// session.close();
			// }
		}

		return dependencia;
	}

	// Metodo para consultar una dependencia por medio del id
	@Override
	public Dependencia get(Long id) throws MyException {
		Session session = null;
		Criteria criteria = null;
		Dependencia dependencia = null;

		try {
			session = sessionFactory.getCurrentSession();

			// Consulta a trav�s del m�todo load
			dependencia = (Dependencia) session.get(Dependencia.class, id);

		} catch (HibernateException e) {
			throw new MyException("Se encontraron errores consultando las Dependencias", e);
		} finally {

		}

		return dependencia;
	}

	// Metodo para Insertar una Dependencia
	@Override
	public void insert(Dependencia dependencia) throws MyException {
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.getCurrentSession();

			// Guardar una dependencia en la base de datos
			session.save(dependencia);

		} catch (HibernateException e) {
			throw new MyException("Ocurrio un error almacenando la dependencia", e);
		} finally {

		}

	}

	// Metodo para modificar una dependencia
	@Override
	public void update(Dependencia dependencia) throws MyException {
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			session.update(dependencia);
			tx.commit();
		} catch (HibernateException e) {
			throw new MyException("Ocurrio un error modificando la dependencia", e);
		} finally {

		}

	}

	// Metodo para borrar una dependencia
	@Override
	public void delete(Dependencia dependencia) throws MyException {
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			session.delete(dependencia);
			tx.commit();
		} catch (HibernateException e) {
			throw new MyException("Ocurrio un error eliminando la dependencia", e);
		} finally {

		}

	}

}
