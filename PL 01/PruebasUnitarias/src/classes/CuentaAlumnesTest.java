package classes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CuentaAlumnesTest {

	// 1. No se pueden hacer ingresos en metalico superiores a 3000 euros
	// 2. Al retirar dinero no se puede dejar una cuenta con un balance negativo superior a 1500 euros
	// 3. Cuando se crea una cuenta con un balance negativo superior a 1500 euros la cuenta se crea directamente congelada
	// 4. De las cuentas congeladas no se puede retirar dinero
	
	@Test
	void testCuentaAlumnesStringFloat() {
		// Caso prueba cuenta normal
		String nombre = "cuenta normal";
		float balance = 10;
		CuentaAlumnes cuenta = new CuentaAlumnes(nombre, balance);
		
		assertEquals(nombre, cuenta.getNombreCliente());
		assertEquals(balance, cuenta.getBalance());
		assertTrue(!cuenta.estaCongelada());
		
		// Caso prueba cuenta congelada
		nombre = "cuenta congelada";
		balance = -1501;
		cuenta = new CuentaAlumnes(nombre, balance);
		
		assertEquals(nombre, cuenta.getNombreCliente());
		assertEquals(balance, cuenta.getBalance());
		assertTrue(cuenta.estaCongelada());
	}

	@Test
	void testIngresar() {
		CuentaAlumnes cuenta = new CuentaAlumnes();
		
		// Ingreso valido
		float balance = cuenta.getBalance();
		
		float ingreso = 10;
		cuenta.Ingresar(ingreso);
		assertEquals(balance + ingreso, cuenta.getBalance());
		
		// Ingreso no valido
		balance = cuenta.getBalance();
		
		ingreso = 3001;
		cuenta.Ingresar(ingreso);
		assertEquals(balance, cuenta.getBalance());
	}

	@Test
	void testRetirar() {
		CuentaAlumnes cuenta = new CuentaAlumnes();
		
		// Retiro no valido (Balance inferior a 1500 euros)
		float retiro = 1501;
		cuenta.Retirar(retiro);
		assertEquals(0, cuenta.getBalance());
		
		// Retiro valido
		retiro = 1000;
		cuenta.Retirar(retiro);
		assertEquals(-retiro, cuenta.getBalance());
		
		// Retiro no valido (Cuenta congelada)
		float balance = -2000;
		cuenta = new CuentaAlumnes("", balance);
		cuenta.Retirar(retiro);
		assertEquals(balance, cuenta.getBalance());
	}

	@Test
	void testTransferirFondos() {
		// Transferencia no valida (Cuenta congelada)
		float balance = -2000;
		CuentaAlumnes cuenta = new CuentaAlumnes("", balance);
		
		float transferencia = 100;
		cuenta.TransferirFondos(new CuentaAlumnes(), transferencia);
		assertEquals(balance, cuenta.getBalance());
		
		// Transferencia valida
		cuenta = new CuentaAlumnes();
		cuenta.TransferirFondos(new CuentaAlumnes(), transferencia);
		assertEquals(-transferencia, cuenta.getBalance());
		
		// Transferencia no valida (Balance inferior a 1500 euros)
		cuenta = new CuentaAlumnes();
		transferencia = 1501;
		cuenta.TransferirFondos(new CuentaAlumnes(), transferencia);
		assertEquals(0, cuenta.getBalance());
	}

}
