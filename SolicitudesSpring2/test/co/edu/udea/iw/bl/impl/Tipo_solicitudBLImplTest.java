package co.edu.udea.iw.bl.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.bl.Tipo_solicitudBL;
import co.edu.udea.iw.dto.Tipo_solicitud;
import co.edu.udea.iw.exception.MyException;

@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:configuracion.xml")
@Transactional

public class Tipo_solicitudBLImplTest {
	
	@Autowired
	Tipo_solicitudBL tipo_solicitudBL;
	
	@Test
	public void testObtener() {
		List<Tipo_solicitud> lista=null;
		
		try{
			lista=tipo_solicitudBL.obtener();
			
			assertTrue (lista.size()>0);			
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testGuardar() {
		//List<Tipo_solicitud> lista=null;
		
		try{
			tipo_solicitudBL.guardar(6l, "Solicitudes pedido");		
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
