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
		/**
		 * A measure to ensure that the value of the first string is not less
		 * than the value of the second string. Checking whether the first
		 * answer from the calculation is a negative so as to exit the program
		 * in compliance with assignment.
		 */
		if (Integer.parseInt(tal1) - Integer.parseInt(tal2) < 0) {
			System.out
					.println("To carry out subtruction, the value of the first string\n"
							+ " shouldn't be less than the value of the second string. Try again");
			System.exit(0);
		}

		// Subtracting the numbers and showing their results.
		String diferens = subtrahera(tal1, tal2);
		visa(tal1, tal2, diferens, '-');

		/*
		 * multiplicera heltalen och visa resultatet String multi =
		 * subtrahera(tal1, tal2); visa(tal1, tal2, diferens, '-');
		 */
	}

	/**
	 * addera receives two natural numbers entered as strings and returns their
	 * Value
	 * 
	 * @param tal1
	 * @param tal2
	 * @return
	 */
	public static String addera(String tal1, String tal2) {

		String resultat = new String();

		// function call and a way to ensure that both strings are of the same
		// length.
		if (tal1.length() > tal2.length()) {
			tal2 = addZeros(tal2, tal1.length());// funktion anrop
		} else if (tal2.length() > tal1.length()) {
			tal1 = addZeros(tal1, tal2.length());
		}

		// filling the contents of the string
		for (int i = 0; i < tal1.length(); i++) {
			// Conversion from character to integer
			int talett = Character.getNumericValue(tal1.charAt(i));
			int taltva = Character.getNumericValue(tal2.charAt(i));

			int svar = talett + taltva;

			if (svar > 9) {
				if (resultat.length() == 0)// Checking if this is the first
											// digit

				{
					resultat = resultat + Integer.toString(svar);// Conversion
																	// from
																	// integer
																	// to string

				} else {
					resultat = lendDigits2(resultat, i, svar);
				}

			} else

			{
				resultat = resultat + Integer.toString(svar);// Conversion from
																// integer to
																// string
}

		}

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
	private static String addZeros(String tal, int length)

	{
		while (tal.length() < length) {
			tal = "0" + tal;

		}

		return tal;

	}

	/**
	 * subtrahera receives two natural numbers as strings and returns
	 * 
	 * @param tal1
	 * @param tal2
	 * @return their difference as a string
	 */
	public static String subtrahera(String tal1, String tal2) {

		String resultat = new String();
		
		if (tal1.length() > tal2.length()) {

			tal2 = addZeros(tal2, tal1.length());// funktion anrop
		} else if (tal2.length() > tal1.length()) {
			tal1 = addZeros(tal1, tal2.length());
		}
		
		
		// subtrahera innehållet i strängarna
		// omvandla tecken till siffror
		int lenddigit = 0;
		for (int i = (tal1.length()-1); 0 <= i ; i--) {
			int talett = Character.getNumericValue(tal1.charAt(i));
			int taltva = Character.getNumericValue(tal2.charAt(i));
			int svar = 0;
			
			if (talett==0 & lenddigit == 1)//If digit=0 and has borrowed(1) previousely, make digit = 9
			{
				talett = 9;
				svar = talett - taltva;//9 - taltva
				lenddigit = 1;
			// otherwise check if talett is less than taltva, and if so, add 10 to talett then lenddigit = 1
			} else if ((talett-lenddigit) < taltva) {
				talett = talett + 10;
				svar = talett - taltva;
				lenddigit = 1;
			// otherwise just take the difference between  talett(minus lenddigit if there is one) and taltva
			// lenddigit  = 0 since no digitis were borrowed 
			} else {
				svar=(talett-lenddigit)-taltva;
				lenddigit = 0;
			}
			// add the svar digit to the resultat string
				resultat =  Integer.toString(svar)+resultat ;
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
		int previousDigit = Character.getNumericValue(resultat.charAt(i - 1));// Checking
																				// the
																				// previous
																				// digit

		System.out.println("previousDigit: " + previousDigit);
		previousDigit = previousDigit + 1;
		resultat = resultat.substring(0, i - 1) + previousDigit + (svar - 10);
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
	private static String addZeros2(String tal, int length) {
		while (tal.length() < length) {
			tal = "0" + tal;

		}

		return tal;

	}

	/**
	 * public static String multiplicera(String tal1, String tal2) {
	 * 
	 * return ""; }
	 */

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
		out.println("  " + tal1);
		out.println("" + operator + " " + tal2);
		for (int i = 0; i < maxLen + 2; i++)
			out.print("-");
		out.println();
		out.println("  " + resultat + "\n");
	
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
