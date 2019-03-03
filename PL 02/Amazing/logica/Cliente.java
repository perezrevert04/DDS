package logica;

public class Cliente {

  private String nombre, direccion, codPostal, telefono;

  /**
	* Default Cliente constructor
	*/
	public Cliente(String nombre, String direccion, String codPostal, String telefono) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.codPostal = codPostal;
		this.telefono = telefono;
	}

	/**
	* Returns value of nombre
	* @return
	*/
	public String getNombre() {
		return nombre;
	}

	/**
	* Sets new value of nombre
	* @param
	*/
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	* Returns value of direccion
	* @return
	*/
	public String getDireccion() {
		return direccion;
	}

	/**
	* Sets new value of direccion
	* @param
	*/
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	* Returns value of codPostal
	* @return
	*/
	public String getCodPostal() {
		return codPostal;
	}

	/**
	* Sets new value of codPostal
	* @param
	*/
	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	/**
	* Returns value of telefono
	* @return
	*/
	public String getTelefono() {
		return telefono;
	}

	/**
	* Sets new value of telefono
	* @param
	*/
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	* Create string representation of Cliente for printing
	* @return
	*/
	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", direccion=" + direccion + ", codPostal=" + codPostal + ", telefono=" + telefono + "]";
	}
}
