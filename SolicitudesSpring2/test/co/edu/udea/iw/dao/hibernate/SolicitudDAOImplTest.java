package co.edu.udea.iw.dao.hibernate;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.SolicitudDAO;
import co.edu.udea.iw.dto.Solicitud;
import co.edu.udea.iw.exception.MyException;

/**
 * Implementación de la interface {@link SolicitudDAO}
 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")

public class SolicitudDAOImplTest {
	/**
	 * Realiza prueba de la implementación
	 */
	@Autowired
	SolicitudDAO solicitudDao;
	
	@Test
	public void testGet() {
		List<Solicitud> solicitudes=null;
		
		try{
			solicitudes=solicitudDao.get();
			
			//Itero las solicitudes para mostrar el contenido
			for(Solicitud solicitud: solicitudes){
				System.out.println(solicitud.getId()+":"+ solicitud.getTipo_Solicitud_id().getNombre()+":"+ solicitud.getFecha()+
						":"+solicitud.getContenido()+":"+solicitud.getUsuario_Id().getId());
			}
			assertTrue(solicitudes.size()>0);
			
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testGetUno(){
		Solicitud solicitud = null;
		
		try{

			solicitud = solicitudDao.get(100l);
			
			assertNotNull(solicitud);
			
			System.out.println(solicitud.getId()+":"+ solicitud.getTipo_Solicitud_id().getNombre()+":"+ solicitud.getFecha()+
					":"+solicitud.getContenido()+":"+solicitud.getUsuario_Id().getId());
			
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testInsert(){
		Solicitud solicitud = new Solicitud();
		
		try{
			solicitud.setId(7l);
			solicitud.getTipo_Solicitud_id().getNombre();
			solicitud.setFecha(new Date());
			solicitud.setContenido("Nevera en mal estado");
			solicitud.getUsuario_Id().getId();
			
			solicitudDao.insert(solicitud);
			
			
		}catch(MyException e){
			e.printStackTrace();
		}
	}
}
