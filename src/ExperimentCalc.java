import java.util.*; // Scanner

import static java.lang.System.out;

public class ExperimentCalc {

	public static void main(String[] args) {

		out.println("OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRANGAR");
		out.println("---------------------------------------------------------");
		out.println();
		out.println();

		// mata in tv� naturliga heltal
		Scanner in = new Scanner(System.in);
		out.println("Mata in tv� naturliga heltal ");
		out.println("-----------------------------");
		out.println();
		String tal1 = in.next();
		out.println();
		String tal2 = in.next();
		out.println();

		// addera heltalen och visa resultatet
		String summa = addera(tal1, tal2);
		visa(tal1, tal2, summa, '+');

		// subtrahera heltalen och visa resultatet
		String diferens = subtrahera(tal1, tal2);
		visa(tal1, tal2, diferens, '-');
		
		/*multiplikation
		String multi= multiplicera(tal1,tal2);
		visa(tal1,tal2,'*');*/

	}

	// addera tar emot tv� naturliga heltal givna som teckenstr�ngar, och
	// returnerar deras
	// summa som en teckenstr�ng.
	public static String addera(String tal1, String tal2) {

		String resultat = new String();

		if (tal1.length() > tal2.length()) {
			tal2 = addZeros(tal2, tal1.length());// funktion anrop
		} else if (tal2.length() > tal1.length()) {
			tal1 = addZeros(tal1, tal2.length());
		}

		// addera inneh�llet i str�ngarna
		for (int i = 0; i < tal1.length(); i++) {
			// omvandla tecken till siffror
			int talett = Character.getNumericValue(tal1.charAt(i));
			int taltva = Character.getNumericValue(tal2.charAt(i));

			int svar = talett + taltva;

			if (svar > 9) {
				if (resultat.length() == 0)// Kolla om denna �r den f�rsta
											// tecknet
				{
					resultat = resultat + Integer.toString(svar);// omv�ndla
																	// fr�n
																	// sifra
																	// till
																	// str�ng

				} else {
					resultat = lendDigits(resultat, i, svar);
				}

			} else

			{
				resultat = resultat + Integer.toString(svar);// fr�n sifra till
																// str�ng
			}

		}

		return resultat;

	}

	/**
	 * 
	 * 
	 * @param resultat
	 *            the string with the preliminary result
	 * @param i
	 *            the current position of the loop
	 * @param svar
	 *            the result of the addition of the current digits
	 * @return the result of the calculation
	 */
	private static String lendDigits(String resultat, int i, int svar) {
		int previousDigit = Character.getNumericValue(resultat.charAt(i - 1));// kontrolera
																				// det
		// f�reng�ende
		// tecknet
		System.out.println("previousDigit: " + previousDigit);
		previousDigit = previousDigit + 1;
		System.out.println("previousDigit = previousDigit + 1; "
				+ previousDigit);//

		System.out.println("resultat: " + resultat);
		resultat = resultat.substring(0, i - 1) + previousDigit + (svar - 10);
		System.out.println("resultat after: " + resultat);
		return resultat;
	}

	/**
	 * 
	 * @param tal
	 *            the short number
	 * @param length
	 *            the target length
	 * @return the number tal but padded with zeroes in front
	 */
	private static String addZeros(String tal, int length) // l�gga till nollor
															// tills tal har
															// samma l�ngd som
															// length
	{
		while (tal.length() < length) {
			tal = "0" + tal;

		}

		return tal;

	}

	// subtrahera tar emot tv� naturliga heltal givna som teckenstr�ngar, och
	// returnerar
	// deras differens som en teckenstr�ng.
	// Det f�rsta heltalet �r inte mindre �n det andra heltalet.
	public static String subtrahera(String tal1, String tal2) {


		String resultat = new String();

		if (tal1.length() > tal2.length()) {
			tal2 = addZeros(tal2, tal1.length());// funktion anrop
		} else if (tal2.length() > tal1.length()) {
			tal1 = addZeros(tal1, tal2.length());
		}

		// subtrahera inneh�llet i str�ngarna
		for (int i = 0; i < tal1.length(); i++) {
			// omvandla tecken till siffror

			int talett = Character.getNumericValue(tal1.charAt(i));
			int taltva = Character.getNumericValue(tal2.charAt(i));

			int svar = talett - taltva;

			if (svar > 9)
			{
				if (resultat.length() == 0)// Kolla om denna �r den f�rsta
											// tecknet
				{
					resultat = resultat + Integer.toString(svar);// omv�ndla
																	// fr�n
																	// sifra
																	// till
																	// str�ng

				} 
				else {
					resultat = lendDigits(resultat, i, svar);
				}

			} 
			else 
				
			{
				resultat = resultat + Integer.toString(svar);// fr�n sifra till
																// str�ng
			}

		}

		return resultat;

	}

	/**
	 * 
	 * 
	 * @param resultat
	 *            the string with the preliminary result
	 * @param i
	 *            the current position of the loop
	 * @param svar
	 *            the result of the addition of the current digits
	 * @return the result of the calculation
	 */
	private static String lendDigits2(String resultat, int i, int svar) {
		int previousDigit = Character.getNumericValue(resultat.charAt(i - 1));// kontrolera
																				// det
																				// f�reng�ende
																				// tecknet
		System.out.println("previousDigit: " + previousDigit);
		previousDigit = previousDigit + 1;
		System.out.println("previousDigit = previousDigit + 1; "
				+ previousDigit);

		System.out.println("resultat: " + resultat);
		resultat = resultat.substring(0, i - 1) + previousDigit + (svar - 10);
		System.out.println("resultat after: " + resultat);
		return resultat;
	}

	/**
	 * 
	 * @param tal
	 *            the short number
	 * @param length
	 *            the target length
	 * @return the number tal but padded with zeroes in front
	 */
	private static String addZeros2(String tal, int length) // l�gga till nollor
															// tills tal har
															// samma l�ngd som
															// length
	{
		while (tal.length() < length) {
			tal = "0" + tal;

		}

		return tal;

	}
	/**
	 */
	public static String multiplicera(String tal1, String tal2){
		
		
		
		
		
		return"";
	}
	
	

	// visa visar tv� givna naturliga heltal, och resultatet av en aritmetisk
	// operation
	// utf�rd i samband med hetalen
	public static void visa(String tal1, String tal2, String resultat,
			char operator) {
		// s�tt en l�mplig l�ngd p� heltalen och resultatet
		int len1 = tal1.length();
		int len2 = tal2.length();
		int len = resultat.length();
		int maxLen = Math.max(Math.max(len1, len2), len);
		tal1 = sattLen(tal1, maxLen - len1);
		tal2 = sattLen(tal2, maxLen - len2);
		resultat = sattLen(resultat, maxLen - len);
		// visa heltalen och resultatet
		out.println(" " + tal1);
		out.println("" + operator + " " + tal2);

		for (int i = 0; i < maxLen + 2; i++)
			out.print("-");
		out.println();
		out.println(" " + resultat + "\n");
	}

	// sattLen l�gger till ett angivet antal mellanslag i b�rjan av en given
	// str�ng
	public static String sattLen(String s, int antal) {
		StringBuilder sb = new StringBuilder(s);
		for (int i = 0; i < antal; i++)
			sb.insert(0, " ");
		return sb.toString();
	}

}
