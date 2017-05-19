package co.edu.udea.iw.bl.impl;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.bl.SolicitudBL;
import co.edu.udea.iw.dto.Solicitud;
import co.edu.udea.iw.exception.MyException;

@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:configuracion.xml")
@Transactional

public class SolicitudBLImplTest {
	
	@Autowired
	SolicitudBL solicitudBL;
	
	@Test
	public void testObtener() {
		List<Solicitud> lista=null;
		
		try{
			lista = solicitudBL.obtener();
			
			assertTrue (lista.size()>0);			
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testGuardar() {
		//List<Solicitud> lista=null;
		
		try{
			solicitudBL.guardar(5l, new Date(), "La factura ha sido corregida");	
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
