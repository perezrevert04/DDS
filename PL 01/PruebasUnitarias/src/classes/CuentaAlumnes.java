package classes;

/**
 *
 * @author carpere2
 */
public class CuentaAlumnes {
     
   
    private String nombreCliente;
    
    private float balance = 0;
    
    private boolean cuentaCongelada = false;
  
    public CuentaAlumnes() { }
    
    public CuentaAlumnes(String nombre, float balance){
    	nombreCliente = nombre;
    	this.balance = balance;
    	if (balance < -1500) {
    		cuentaCongelada = true;
    	}
    }
    
    
    public void Ingresar(float cantidad)   {
    	if (cantidad <= 3000)
    		balance += cantidad;
    }

    public void Retirar(float cantidad)  {
    	if (balance - cantidad >= -1500)
    		balance -= cantidad;
    }

    public void TransferirFondos(CuentaAlumnes destino, float cantidad)
    {
    	if (balance - cantidad >= -1500) {
    		destino.Ingresar(cantidad);
    		Retirar(cantidad);  
        } 
    }
    
    public void CongelarCuenta(){
    	cuentaCongelada = true;
    }
    
    public void DescongelarCuenta(){
    	cuentaCongelada = false;
    }

	public String getNombreCliente() {
		return nombreCliente;
	}

	public float getBalance() {
		return balance;
	}

	public boolean estaCongelada(){
		return cuentaCongelada;
	}
    
}
