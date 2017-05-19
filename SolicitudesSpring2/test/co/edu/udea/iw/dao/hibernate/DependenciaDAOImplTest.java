package co.edu.udea.iw.dao.hibernate;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.DependenciaDAO;
import co.edu.udea.iw.dto.Dependencia;
import co.edu.udea.iw.exception.MyException;

/**
 * Implementación de la interface {@link DependenciaDAO}
 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")

public class DependenciaDAOImplTest{

	/**
	 * Realiza prueba de la implementación
	 */	
	@Autowired
	DependenciaDAO dependenciaDao;
	
	@Test
	public void testGet() {
		List<Dependencia> dependencias=null;
		
		try{
			
			dependencias=dependenciaDao.get();
			
			//Itero las dependencias para mostrar el contenido
			for(Dependencia dependencia: dependencias){
				System.out.println(dependencia.getId()+":"+ dependencia.getNombre());
			}
			//Valida que el objeto no sea nulo
			assertTrue(dependencias.size()>0);
			
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	//Consulta
	@Test
	public void testGetUno(){
		Dependencia dependencia = null;
		
		try{
			
			dependencia = dependenciaDao.get(1l);
			
			assertNotNull(dependencia);
			
			System.out.println(dependencia.getId() + ": " +  dependencia.getNombre());
			
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	//Creación de nueva dependencia
	@Test
	public void testInsert(){
		Dependencia dependencia = new Dependencia();
		
		try{
			dependencia.setId(6l);
			dependencia.setNombre("Finanzas");
			
	
			dependenciaDao.insert(dependencia);
			
			
		}catch(MyException e){
			e.printStackTrace();
		}
	}
}
