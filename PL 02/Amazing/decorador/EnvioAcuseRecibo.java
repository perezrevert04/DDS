package decorador;

import logica.*;

public class EnvioAcuseRecibo extends EnvioDecorador {

  private static final double PRECIO_ACUSE_RECIBO = 2.5;

  public EnvioAcuseRecibo(E envio) {
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
    return super.calcularPrecio() + PRECIO_ACUSE_RECIBO;
  }
}
