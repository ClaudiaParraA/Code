package text2number;

import java.util.Scanner;
import java.util.StringTokenizer;

public class TextNumber {
	String[] numberText = { "ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE",
			"SIX", "SEVEN", "EIGHT", "NINE", "TEN", "ELEVEN", "TWELVE",
			"THIRTEEN", "FOURTEEN", "FIFTEEN", "SIXTEEN", "SEVENTEEN",
			"EIGHTEEN", "NINETEEN", "TWENTY", "THIRTY", "FORTY", "FIFTY",
			"SIXTY", "SEVENTY", "EIGHTY", "NINETY", "HUNDRED", "THOUSAND",
			"MILLION" };

	Integer[] numberInt = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
			15, 16, 17, 18, 19, 20, 30, 40, 50, 60, 70, 80, 90, 100, 1000,
			1000000 };
	
	public static final String MILLION = "MILLION";
	public static final String THOUSAND = "THOUSAND";
	public static final String HUNDRED = "HUNDRED";

	/**
	 * Metodo principal
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		TextNumber myApp = new TextNumber();
		String numeroUno = "";
		String numeroDos = "";
		Scanner sc = new Scanner(System.in);
		System.out
				.println("Introduzca el texto del primer número  en inglés: ");
		numeroUno = sc.nextLine();
		System.out
				.println("Introduzca el texto del segundo número  en inglés:");
		numeroDos = sc.nextLine();
		sc.close();

		System.out
				.println("Numero 1: " + numeroUno + " Numero 2: " + numeroDos);

		System.out.println("Resultado= " + myApp.suma(numeroUno, numeroDos));

		myApp.transformaCadena(numeroUno);
	}

	/**
	 * Suma dos numeros escritos en ingles
	 * 
	 * @param numeroUno
	 *            texto del primer numero
	 * @param numeroDos
	 *            texto del segundo numero
	 * @return int con el resultado de la suma
	 */
	public int suma(String numeroUno, String numeroDos) {
		int numIntUno = letters2numbers(numeroUno);
		int numIntDos = letters2numbers(numeroDos);
		int suma = 0;
		if (numIntUno >= 0 && numIntDos >= 0) {
			suma = numIntUno + numIntDos;
		}
		return suma;
	}

	/**
	 * Transforma un numero de texto a entero
	 * 
	 * @param texto
	 *            numero a transformar
	 * @return entero con el valor obtenido
	 */
	public int letters2numbers(String texto) {
		texto = texto.toUpperCase(); // "NINE HUNDRED AND NINETY-NINE THOUSAND";
		texto = texto.replace('-', ' ');
		StringTokenizer st = new StringTokenizer(texto);
		int numero = 0, acumulado = 0, previous = 0;

		while (st.hasMoreTokens()) {
			String t = st.nextToken();
			boolean found = false;
			for (int x = 0; x < numberText.length; x++) {
				if (t.equals(numberText[x])) {
					found = true;
					previous = numero;
					numero = numberInt[x];
					if (numero >= 100) {
						acumulado += previous * numero;
						acumulado -= previous;
					} else {
						acumulado = acumulado + numero;
					}
				}
			}
			if (!found) {
				return -1;
			}

		}

		return acumulado;
	}

	/**
	 * Transforma un numero de texto a entero
	 * 
	 * @param texto
	 *            numero a transformar
	 * @return entero con el valor obtenido
	 */
	public int transformaCadena(String texto) {
		texto = texto.toUpperCase(); // "NINE HUNDRED AND NINETY-NINE";
		texto = texto.replace('-', ' ');
		texto = texto.replace(" AND ", " ");
		int numeroEntrante = 0;
		int cantMill = 0, cantThou = 0, cantHund = 0, cantUnid = 0;
		
		//String cadMill = texto.in indexOf(str, fromIndex);
		int indMill = texto.indexOf(MILLION);
		if (indMill > 0){
			String cadMill = texto.substring(0, indMill+MILLION.length());
			texto = texto.substring(indMill+MILLION.length());
			//
			String subCadMillThou = cadMill.substring(0, THOUSAND.length());
			
			//
			cantMill = letters2numbers(cadMill);
			System.out.println("la cadena hasta millones es: " +cadMill);
			System.out.println("el numero en millones: " +cantMill);
		}
		int indThou = texto.indexOf(THOUSAND);
		if (indThou > 0){
			String cadThou = texto.substring(0, indThou+THOUSAND.length());
			texto = texto.substring(indThou+THOUSAND.length());
			cantThou = letters2numbers(cadThou);
			System.out.println("la cadena hasta miles es: " +cadThou);
			System.out.println("el numero en miles: " +cantThou);
		}
		int indHund = texto.indexOf(HUNDRED);
		if (indHund > 0){
			String cadHund = texto.substring(0, indHund+HUNDRED.length());
			texto = texto.substring(indHund+HUNDRED.length());
			cantHund = letters2numbers(cadHund);
			System.out.println("la cadena hasta cientos es: " +cadHund);
			System.out.println("el numero para cientos: " +cantHund);
		}
		if (texto.length()>2){
			cantUnid = letters2numbers(texto);
			System.out.println("la cadena para unidades y decenas es: " +texto);
			System.out.println("el numero de unidades y decenas: " +cantUnid);
		}
		numeroEntrante = cantMill + cantThou + cantHund + cantUnid;
		System.out.println("el numero entero ingresado segun nuevo metodo es: " +numeroEntrante);
		return numeroEntrante;
		
	}

}
