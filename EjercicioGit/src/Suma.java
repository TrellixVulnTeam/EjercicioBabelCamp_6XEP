
public class Suma {
	
	//Clase que realiza la suma
	//Se puede usar el m�todo para sumar dos n�mero o una suma acumulada
	
	static int acum = 0;
	
	public static int suma(int n, int m) {
		return n + m;
	}
	
	public static int sumaAcum(int n) {
		acum += n;
		return acum;
	}
	
}
