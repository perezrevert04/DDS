package logica;

public class Paquete extends Envio {

  private static final double COSTE_POR_GRAMO = 0.02;

  public Paquete(String direccion, String codPostal, double peso) {
    super(direccion, codPostal, peso);
  }

  @Override
  public double calcularPrecio() {
    return super.calcularPrecio() + COSTE_POR_GRAMO * peso;
  }
}
