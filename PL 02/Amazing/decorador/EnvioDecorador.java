package decorador;

import logica.*;

public class EnvioDecorador implements E {

  protected E envio;

  public EnvioDecorador(E envio) {
    this.envio = envio;
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
    return this.envio.calcularPrecio();
  }
}
