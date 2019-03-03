package estrategia;

import logica.*;

public interface EstrategiaEnvio {

  public String getNombre();
  public double calcularPrecio(Envio envio);

}
