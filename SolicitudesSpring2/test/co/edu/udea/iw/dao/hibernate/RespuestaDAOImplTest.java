package co.edu.udea.iw.dao.hibernate;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.RespuestaDAO;
import co.edu.udea.iw.dto.Respuesta;
import co.edu.udea.iw.exception.MyException;

/**
 * Implementación de la interface {@link RespuestaDAO}
 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")

public class RespuestaDAOImplTest {
	/**
	 * Realiza prueba de la implementación
	 */
	@Autowired
	RespuestaDAO respuestaDao;
	
	@Test
	public void testGet() {
		List<Respuesta> respuestas=null;
		
		try{
			
			respuestas=respuestaDao.get();
			
			//Itero las respuestas para mostrar el contenido
			for(Respuesta respuesta: respuestas){
				System.out.println(respuesta.getId()+":"+ respuesta.getSolicitud_Id().getTipo_Solicitud_id()+":"+ respuesta.getUsuario_Id().getId()+":"+
				respuesta.getFecha()+":"+respuesta.getContenido());
			}
			assertTrue(respuestas.size()>0);
			
		}catch(MyException e){
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void testGetUno(){
		Respuesta respuesta = null;
		
		try{
			respuesta = respuestaDao.get(2l);
			
			assertNotNull(respuesta);
			
			System.out.println(respuesta.getId()+":"+ respuesta.getSolicitud_Id().getTipo_Solicitud_id()+":"+ respuesta.getUsuario_Id().getId()+":"+
					respuesta.getFecha()+":"+respuesta.getContenido());
			
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testInsert(){
		Respuesta respuesta = new Respuesta();
		
		try{
			respuesta.setId(102l);
			respuesta.getSolicitud_Id().getTipo_Solicitud_id();
			respuesta.getUsuario_Id().getId();
			respuesta.setFecha(new Date());
			respuesta.setContenido("Rectificar factura F-4875");
			
			respuestaDao.insert(respuesta);
			
			
		}catch(MyException e){
			e.printStackTrace();
		}
	}
}
