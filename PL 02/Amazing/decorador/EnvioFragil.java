package decorador;

import logica.*;

public class EnvioFragil extends EnvioDecorador {

  private static final double PRECIO_FRAGIL = 3;

  public EnvioFragil(E envio) {
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
    return super.calcularPrecio() + PRECIO_FRAGIL;
  }
}
