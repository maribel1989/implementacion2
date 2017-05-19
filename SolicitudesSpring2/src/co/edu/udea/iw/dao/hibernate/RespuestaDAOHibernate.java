package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.edu.udea.iw.dao.RespuestaDAO;
import co.edu.udea.iw.dto.Dependencia;
import co.edu.udea.iw.dto.Respuesta;
import co.edu.udea.iw.exception.MyException;

/**
 * Implementación de RespuestaDAO
 * 
 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 */
public class RespuestaDAOHibernate implements RespuestaDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// Metodo para crear una lista de Respuestas
	@Override
	public List<Respuesta> get() throws MyException {
		// Creacion de sesion a la base de datos
		Session session = null;
		Criteria criteria = null;
		List<Respuesta> respuesta = new ArrayList<Respuesta>();

		try {
			// Obtengo sesion a la base de datos
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(Respuesta.class);
			respuesta = criteria.list();
		} catch (HibernateException e) {
			throw new MyException("Se encontraron errores consultando las respuestas", e);
		} finally {
			// if(session != null){
			// session.close();
			// }
		}

		return respuesta;
	}

	// Metodo para consultar una respuesta por medio del id
	@Override
	public Respuesta get(Long id) throws MyException {
		Session session = null;
		Criteria criteria = null;
		Respuesta respuesta = null;

		try {
			session = sessionFactory.getCurrentSession();

			// Consulta a través del método load
			respuesta = (Respuesta) session.get(Respuesta.class, id);

		} catch (HibernateException e) {
			throw new MyException("Se encontraron errores consultando las Respuestas", e);
		} finally {
			// if(session != null){
			// session.close();
			// }
		}

		return respuesta;
	}

	// Metodo para ingresar una Respuesta
	@Override
	public void insert(Respuesta respuesta) throws MyException {
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.getCurrentSession();
			// Para guardar una respuesta en la base de datos
			session.save(respuesta);
		} catch (HibernateException e) {
			throw new MyException("Ocurrio un error almacenando la respuesta", e);
		} finally {
			// if(session != null){
			// session.close();
			// }
		}

	}

	// Metodo para modificar una Respuesta
	@Override
	public void update(Respuesta respuesta) throws MyException {
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			session.update(respuesta);
			tx.commit();
		} catch (HibernateException e) {
			throw new MyException("Ocurrio un error modificando la respuesta", e);
		} finally {

		}

	}

	// Metodo para borrar una respuesta
	@Override
	public void delete(Respuesta respuesta) throws MyException {
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			session.delete(respuesta);
			tx.commit();
		} catch (HibernateException e) {
			throw new MyException("Ocurrio un error eliminando la respuesta", e);
		} finally {

		}

	}
}
