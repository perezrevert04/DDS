package metodofabrica;

import logica.*;

public class EnvioCreadorConcreto implements EnvioCreador {

  public Envio crearEnvio(String direccion, String codPostal, double peso) {
    Envio envio = null;

    if (peso <= 100) {
      envio = new Carta(direccion, codPostal, peso);
    } else if (peso <= 2000) {
      envio = new Paquete(direccion, codPostal, peso);
    } else {
      envio = new GranVolumen(direccion, codPostal, peso);
    }

    return envio;
  }

}
