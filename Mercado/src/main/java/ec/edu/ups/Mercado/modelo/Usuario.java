package ec.edu.ups.Mercado.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario {

	@Id
	private String cedula;
	private String nombre;
	private String apellido;
	private String correo;
	private String contrasenia;
	private String direccion;
	private String telefono;
	private int rol;

	/**
	 * Creacion de relacciones
	 */
	@OneToMany//(fetch = FetchType.EAGER)
	private List<Factura> facturas;

	@OneToMany/*(fetch = FetchType.EAGER)*/
	private List<FacProv> factProv;

	/**
	 * Generar getters and setters
	 */
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public List<FacProv> getFactProv() {
		return factProv;
	}

	public void setFactProv(List<FacProv> factProv) {
		this.factProv = factProv;
	}
	
}
