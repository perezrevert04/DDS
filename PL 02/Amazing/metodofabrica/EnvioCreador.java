package metodofabrica;

import logica.*;

public interface EnvioCreador {

  public Envio crearEnvio(String direccion, String codPostal, double peso);

}
