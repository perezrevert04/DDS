package logica;

import estrategia.*;

public class Envio implements E {

  protected static int idGlobal;
  protected int id;
  protected String direccion, codPostal;
  protected double peso; // peso en gramos
  protected EstrategiaEnvio estrategia;

	/**
	* Default Envio constructor
	*/
	public Envio(String direccion, String codPostal, double peso) {
		if (idGlobal >= 0) {
      id = idGlobal ++;
    } else {
      idGlobal = 0;
      id = 0;
    }
		this.direccion = direccion;
		this.codPostal = codPostal;
		this.peso = peso;
    this.estrategia = null;
	}

	/**
	* Returns value of idGlobal
	* @return
	*/
	public static int getIdGlobal() {
		return idGlobal;
	}

	/**
	* Sets new value of idGlobal
	* @param
	*/
	public static void setIdGlobal(int idGlobal) {
		Envio.idGlobal = idGlobal;
	}

	/**
	* Returns value of id
	* @return
	*/
	public int getId() {
		return id;
	}

	/**
	* Sets new value of id
	* @param
	*/
	public void setId(int id) {
		this.id = id;
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
	* Returns value of peso
	* @return
	*/
	public double getPeso() {
		return peso;
	}

	/**
	* Sets new value of peso
	* @param
	*/
	public void setPeso(double peso) {
		this.peso = peso;
	}

  /**
	* Returns value of nombre estrategia
	* @return
	*/
  @Override
	public String getNombreEstrategia() {
		return estrategia.getNombre();
	}

  public EstrategiaEnvio seleccionarEstrategia() {
    EstrategiaEnvio estrategia = null;

    if (codPostal.startsWith("15") && codPostal.startsWith("36") &&
        codPostal.startsWith("32") && codPostal.startsWith("27") &&
        codPostal.startsWith("33") && codPostal.startsWith("39") &&
        codPostal.startsWith("48") && codPostal.startsWith("20")) {
      estrategia = new EstrategiaCorreos();
    } else if (codPostal.startsWith("25") && codPostal.startsWith("08") &&
        codPostal.startsWith("17") && codPostal.startsWith("43") &&
        codPostal.startsWith("12") && codPostal.startsWith("46") &&
        codPostal.startsWith("03") && codPostal.startsWith("30")) {
      estrategia = new EstrategiaDHL();
    } else {
      estrategia = new EstrategiaSeur();
    }

    return estrategia;
  }

  @Override
  public double calcularPrecio() {
    estrategia = seleccionarEstrategia();
    return estrategia.calcularPrecio(this);
  }

	/**
	* Create string representation of Envio for printing
	* @return
	*/
	@Override
	public String toString() {
		return "Envio [id=" + id + ", direccion=" + direccion + ", codPostal=" + codPostal + ", peso=" + peso + "]";
	}
}
