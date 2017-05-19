package co.edu.udea.iw.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Rol_UsuarioWS {

	// Id del tipo de rol
	private Long id;
	// Nombre del rol
	private String tipo_Rol;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo_Rol() {
		return tipo_Rol;
	}

	public void setTipo_Rol(String tipo_Rol) {
		this.tipo_Rol = tipo_Rol;
	}

}
