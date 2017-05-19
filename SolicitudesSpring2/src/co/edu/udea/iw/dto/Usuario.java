package co.edu.udea.iw.dto;

import java.io.Serializable;

/**
 * DTO para la tabla Usuario
 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 *
 */

public class Usuario implements Serializable{
	//Identificacion del usuario de la base de datos
	private Long id;
	//Id de la dependencia a la cual pertenece el funcionario
	private Dependencia Dependencia_id;
	//Nombre del usuario
	private String nombre;
	//Apellido del usuario
	private String apellido;
	//Telefono del usuario
	private String telefono;
	//Direccion del usuario
	private String direccion;
	//Email del usuario
	private String email;
	//Contrase�a del usuario
	private String contrase�a;
	//username del usuario
	private String username;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Dependencia getDependencia_id() {
		return Dependencia_id;
	}
	public void setDependencia_id(Dependencia dependencia_id) {
		Dependencia_id = dependencia_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	
}
