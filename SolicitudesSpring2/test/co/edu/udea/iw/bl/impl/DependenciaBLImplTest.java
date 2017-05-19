package co.edu.udea.iw.bl.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.bl.DependenciaBL;
import co.edu.udea.iw.dto.Dependencia;
import co.edu.udea.iw.exception.MyException;

@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:configuracion.xml")
@Transactional

public class DependenciaBLImplTest {
	
	@Autowired
	DependenciaBL dependenciaBL;
	
	@Test
	public void testObtener() {
		List<Dependencia> lista=null;
		
		try{
			lista=dependenciaBL.obtener();
			
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
			dependenciaBL.guardar(7l, "Gerencia");		
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
