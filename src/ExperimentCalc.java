import java.util.*; // Scanner

import static java.lang.System.out;

public class ExperimentCalc {

	public static void main(String[] args) {

		out.println("OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRANGAR");
		out.println("---------------------------------------------------------");
		out.println();
		out.println();

		// mata in två naturliga heltal
		Scanner in = new Scanner(System.in);
		out.println("Mata in två naturliga heltal ");
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

	// addera tar emot två naturliga heltal givna som teckensträngar, och
	// returnerar deras
	// summa som en teckensträng.
	public static String addera(String tal1, String tal2) {

		String resultat = new String();

		if (tal1.length() > tal2.length()) {
			tal2 = addZeros(tal2, tal1.length());// funktion anrop
		} else if (tal2.length() > tal1.length()) {
			tal1 = addZeros(tal1, tal2.length());
		}

		// addera innehållet i strängarna
		for (int i = 0; i < tal1.length(); i++) {
			// omvandla tecken till siffror
			int talett = Character.getNumericValue(tal1.charAt(i));
			int taltva = Character.getNumericValue(tal2.charAt(i));

			int svar = talett + taltva;

			if (svar > 9) {
				if (resultat.length() == 0)// Kolla om denna är den första
											// tecknet
				{
					resultat = resultat + Integer.toString(svar);// omvändla
																	// från
																	// sifra
																	// till
																	// sträng

				} else {
					resultat = lendDigits(resultat, i, svar);
				}

			} else

			{
				resultat = resultat + Integer.toString(svar);// från sifra till
																// sträng
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
		// förengående
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
	private static String addZeros(String tal, int length) // lägga till nollor
															// tills tal har
															// samma längd som
															// length
	{
		while (tal.length() < length) {
			tal = "0" + tal;

		}

		return tal;

	}

	// subtrahera tar emot två naturliga heltal givna som teckensträngar, och
	// returnerar
	// deras differens som en teckensträng.
	// Det första heltalet är inte mindre än det andra heltalet.
	public static String subtrahera(String tal1, String tal2) {


		String resultat = new String();

		if (tal1.length() > tal2.length()) {
			tal2 = addZeros(tal2, tal1.length());// funktion anrop
		} else if (tal2.length() > tal1.length()) {
			tal1 = addZeros(tal1, tal2.length());
		}

		// subtrahera innehållet i strängarna
		for (int i = 0; i < tal1.length(); i++) {
			// omvandla tecken till siffror

			int talett = Character.getNumericValue(tal1.charAt(i));
			int taltva = Character.getNumericValue(tal2.charAt(i));

			int svar = talett - taltva;

			if (svar > 9)
			{
				if (resultat.length() == 0)// Kolla om denna är den första
											// tecknet
				{
					resultat = resultat + Integer.toString(svar);// omvändla
																	// från
																	// sifra
																	// till
																	// sträng

				} 
				else {
					resultat = lendDigits(resultat, i, svar);
				}

			} 
			else 
				
			{
				resultat = resultat + Integer.toString(svar);// från sifra till
																// sträng
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
																				// förengående
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
	private static String addZeros2(String tal, int length) // lägga till nollor
															// tills tal har
															// samma längd som
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
	
	

	// visa visar två givna naturliga heltal, och resultatet av en aritmetisk
	// operation
	// utförd i samband med hetalen
	public static void visa(String tal1, String tal2, String resultat,
			char operator) {
		// sätt en lämplig längd på heltalen och resultatet
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

	// sattLen lägger till ett angivet antal mellanslag i början av en given
	// sträng
	public static String sattLen(String s, int antal) {
		StringBuilder sb = new StringBuilder(s);
		for (int i = 0; i < antal; i++)
			sb.insert(0, " ");
		return sb.toString();
	}

}
