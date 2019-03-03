package decorador;

import logica.*;

public class EnvioUrgente extends EnvioDecorador {

  private static final double PRECIO_URGENTE = 2;

  public EnvioUrgente(E envio) {
    super(envio);
  }

  @Override
  public String getNombreEstrategia() {
      return this.envio.getNombreEstrategia();
  }

  @Override
  public int getId() {
    return this.envio.getId();
  }

  @Override
  public double calcularPrecio() {
    return super.calcularPrecio() + PRECIO_URGENTE;
  }
}
