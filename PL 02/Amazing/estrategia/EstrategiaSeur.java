package estrategia;

import logica.*;

public class EstrategiaSeur implements EstrategiaEnvio {

  private static final String NOMBRE = "Correos";
  private static final double PRECIO_CARTA = 0.015;
  private static final double PRECIO_PAQUETE = 0.03;
  private static final double PRECIO_GRAN_VOLUMEN = 0.035;

  @Override
  public String getNombre() { return NOMBRE; }

  @Override
  public double calcularPrecio(Envio envio) {
    double precio = 0;
    double gramos = envio.getPeso();

    if (envio instanceof Carta) {
      precio = gramos * PRECIO_CARTA;
    } else if (envio instanceof Paquete) {
      precio = gramos * PRECIO_PAQUETE;
    } else {
      precio = gramos * PRECIO_GRAN_VOLUMEN;
    }

    return precio;
  }
}
