package co.edu.udea.iw.dao.hibernate;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.Tipo_solicitudDAO;
import co.edu.udea.iw.dto.Tipo_solicitud;
import co.edu.udea.iw.exception.MyException;

/**
 * Implementación de la interface {@link Tipo_solicitudDAO}
 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")

public class Tipo_SolicitudDAOImplTest {
	/**
	 * Realiza prueba de la implementación
	 */
	@Autowired
	Tipo_solicitudDAO tipo_SolicitudDao;
	
	@Test
	public void testGet() {
		List<Tipo_solicitud> Tipo_solicitudes=null;
		
		try{
			Tipo_solicitudes=tipo_SolicitudDao.get();
			
			//Itero los tipos de solicitudes  para mostrar el contenido
			for(Tipo_solicitud tipo_solicitud: Tipo_solicitudes){
				System.out.println(tipo_solicitud.getId()+":"+ tipo_solicitud.getNombre());
			}
			assertTrue(Tipo_solicitudes.size()>0);
			
		}catch(MyException e){
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void testGetUno(){
		Tipo_solicitud tipo_Solicitud = null;
		
		try{
			tipo_Solicitud = tipo_SolicitudDao.get(1l);
			
			assertNotNull(tipo_Solicitud);
			
			System.out.println(tipo_Solicitud.getId() + ": " +  tipo_Solicitud.getNombre());
			
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testInsert(){
		Tipo_solicitud tipo_Solicitud = new Tipo_solicitud();
		
		try{
			tipo_Solicitud.setId(5l);
			tipo_Solicitud.setNombre("Otros");
			
			tipo_SolicitudDao.insert(tipo_Solicitud);
			
			
		}catch(MyException e){
			e.printStackTrace();
		}
	}
}
