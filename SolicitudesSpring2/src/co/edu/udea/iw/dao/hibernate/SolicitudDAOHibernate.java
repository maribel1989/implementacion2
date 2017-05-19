package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.edu.udea.iw.dao.SolicitudDAO;
import co.edu.udea.iw.dto.Dependencia;
import co.edu.udea.iw.dto.Solicitud;
import co.edu.udea.iw.exception.MyException;

/**
 * Implementación de SolicitudDAO
 * 
 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 */
public class SolicitudDAOHibernate implements SolicitudDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// Metodo para crear una lista de Solicitudes
	@Override
	public List<Solicitud> get() throws MyException {
		// Creacion de sesion a la base de datos
		Session session = null;
		Criteria criteria = null;
		List<Solicitud> solicitud = new ArrayList<Solicitud>();

		try {
			// Obtengo sesion a la base de datos
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(Solicitud.class);
			solicitud = criteria.list();
		} catch (HibernateException e) {
			throw new MyException("Se encontraron errores consultando las solicitudes", e);
		} finally {
			// if(session != null){
			// session.close();
			// }
		}

		return solicitud;
	}

	// Metodo para consultar una solicitud por medio del id
	@Override
	public Solicitud get(Long id) throws MyException {
		Session session = null;
		Criteria criteria = null;
		Solicitud solicitud = null;

		try {
			session = sessionFactory.getCurrentSession();

			// Consulta a través del método load
			solicitud = (Solicitud) session.get(Solicitud.class, id);

		} catch (HibernateException e) {
			throw new MyException("Se encontraron errores consultando las Solicitudes", e);
		} finally {
			// if(session != null){
			// session.close();
			// }
		}

		return solicitud;
	}

	// Metodo para Insertar una nueva solicitud
	@Override
	public void insert(Solicitud solicitud) throws MyException {
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.getCurrentSession();
			// Para guardar una dependencia en la base de datos
			session.save(solicitud);
		} catch (HibernateException e) {
			throw new MyException("Ocurrio un error almacenando la solicitud", e);
		} finally {
			// if(session != null){
			// session.close();
			// }
		}

	}

	// Metodo para modificar una solicitud
	@Override
	public void update(Solicitud solicitud) throws MyException {
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			session.update(solicitud);
			tx.commit();
		} catch (HibernateException e) {
			throw new MyException("Ocurrio un error modificando la solicitud", e);
		} finally {

		}

	}

	// Metodo para borrar una solicitud
	@Override
	public void delete(Solicitud solicitud) throws MyException {
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			session.delete(solicitud);
			tx.commit();
		} catch (HibernateException e) {
			throw new MyException("Ocurrio un error eliminando la solicitud", e);
		} finally {

		}

	}
}
