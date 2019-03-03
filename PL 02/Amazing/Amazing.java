import logica.*;
import metodofabrica.*;
import decorador.*;
import java.io.*;
import java.util.*;

public class Amazing {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // Cliente
    Cliente cliente;
    String nomCliente, dirCliente, codPostalCliente, tlfCliente;
    // Envio
    E envio;
    String dirEnvio, codPostalEnvio;
    double peso;

    // Siguiente envio
    boolean siguiente;

    do {
      // Recogida datos del cliente
      System.out.println("DATOS DEL CLIENTE:");
      System.out.print("\tNombre: ");
      nomCliente = sc.nextLine();
      System.out.print("\tDireccion: ");
      dirCliente = sc.nextLine();
      System.out.print("\tCodigo postal: ");
      codPostalCliente = sc.nextLine();
      System.out.print("\tTelefono: ");
      tlfCliente = sc.nextLine();

      // Recogida datos del envio
      System.out.println("\nDATOS DEL ENVIO:");
      System.out.print("\tDireccion: ");
      dirEnvio = sc.nextLine();
      System.out.print("\tCodigo postal: ");
      codPostalEnvio = sc.nextLine();
      System.out.print("\tPeso: ");
      peso = sc.nextInt();

      // Creacion cliente y envio
      cliente = new Cliente(nomCliente, dirCliente, codPostalCliente, tlfCliente);
      envio = new EnvioCreadorConcreto().crearEnvio(dirEnvio, codPostalEnvio, peso);

      // Procesamiento del envio
      double precio = envio.calcularPrecio();
      int id = envio.getId();
      String transportista = envio.getNombreEstrategia();

      // Salida datos envio
      System.out.println("\nDETALLES DEL ENVIO:");
      System.out.println("\tEnvio num: " + id);
      System.out.println("\tCoste total: " + precio);
      System.out.println("\tEmpresa transportista: " + transportista);

      // Consulta de servicios extra
      System.out.println("\nSERVICIOS ADICIONALES:");
      System.out.print("\tUrgente? (s/n) ");
      String entrada = sc.nextLine();
      if ( sc.nextLine().equals("s") )
        envio = new EnvioUrgente(envio);
      System.out.print("\tAcuse recibo? (s/n) ");
      if ( "s".equals(sc.nextLine()) )
        envio = new EnvioAcuseRecibo(envio);
      System.out.print("\tFragil? (s/n) ");
      if ( "s".equals(sc.nextLine()) )
        envio = new EnvioFragil(envio);

      // Calculo del precio final
      precio = envio.calcularPrecio();

      // Salida final de los datos del envio
      System.out.println("\nDETALLES DEL ENVIO:");
      System.out.println("\tEnvio num: " + id);
      System.out.println("\tEmpresa transportista: " + transportista);
      System.out.println("\tPRECIO FINAL: " + precio);

      // Hay siguiente envio?
      System.out.print("\nDesea emitir algun envio mas? (s/n) ");
      siguiente = sc.nextLine().equals("s")? true : false;
    } while (siguiente);

  }
}
