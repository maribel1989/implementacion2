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

import co.edu.udea.iw.bl.RespuestaBL;
import co.edu.udea.iw.dto.Respuesta;
import co.edu.udea.iw.exception.MyException;

@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:configuracion.xml")
@Transactional

public class RespuestaBLImplTest {
	
	@Autowired
	RespuestaBL respuestaBL;
	
	@Test
	public void testObtener() {
		List<Respuesta> lista=null;
		
		try{
			lista = respuestaBL.obtener();
			
			assertTrue (lista.size()>0);			
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testGuardar() {
		//List<Dependencia> lista=null;
		
		try{
			respuestaBL.guardar(8l,new Date(), "IVA Facturado de manera erronea");	
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
