package co.edu.udea.iw.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UsuarioWS {

	// Identificacion del usuario de la base de datos
	private Long id;
	// Id de la dependencia a la cual pertenece el funcionario
	private Dependencia Dependencia_id;
	// Nombre del usuario
	private String nombre;
	// Apellido del usuario
	private String apellido;
	// Telefono del usuario
	private String telefono;

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

}
