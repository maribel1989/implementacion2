package co.edu.udea.iw.bl.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


import co.edu.udea.iw.bl.UsuarioBL;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:configuracion.xml")
@Transactional

public class UsuarioBLImplTest {
	
	@Autowired
	UsuarioBL usuarioBL;
	
	@Test
	public void testObtener() {
		List<Usuario> lista=null;
		
		try{
			lista=usuarioBL.obtener();
			
			assertTrue (lista.size()>0);			
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testGuardar() {
		//List<Usuario> lista=null;
		
		try{
			usuarioBL.guardar(1049l, "Ana Lucia", "Orrego", "3169874512", "analu@gmail.com");
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
