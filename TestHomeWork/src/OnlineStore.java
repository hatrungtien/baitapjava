
public class OnlineStore {
	public static void main(String[] args) {
		int[] validCard1 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6, 7, 0 };
		int[] invalidCard1 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6, 7, 8 };

		System.out.println(validateCreditCard(validCard1));
		System.out.println(validateCreditCard(invalidCard1));

		String validIsbn1 = "0915415770";
		String invalidIsbn1 = "012345678X";

		System.out.println(validateIsbn(validIsbn1));
		System.out.println(validateIsbn(invalidIsbn1));
	}

	public static boolean validateCreditCard(int[] digits) {
		if (digits.length != 16) {
			return false;
		}

		if (!checkAllDigitsValid(digits)) {
			return false;
		}

		return verifyCreditCardChecksum(digits);
	}

	public static boolean validateIsbn(String code) {
		if (code.length() != 10) {
			return false;
		}

		if (!validateIsbnDigits(code)) {
			return false;
		}

		return checkIsbnChecksum(code);
	}

	public static boolean checkIsbnChecksum(String code) {
		int count = 0;
		for (int i = 0; i < code.length() - 1; i++) {
			int digit = code.charAt(i) - '0';
			count = count + (10 - i) * digit;
		}
		char next = code.charAt(9);
		if (next == 'X') {
			count = count + 10;
		} else {
			count = count + (next - '0');
		}

		return count % 11 == 0;
	}

	public static boolean validateIsbnDigits(String code) {
		for (int i = 0; i < 9; i++) {
			if (code.charAt(i) < '0' || code.charAt(i) > '9') {
				return false;
			}
		}

		char last = code.charAt(9);
		return last == 'X' || (last >= '0' && last <= '9');
	}

	public static boolean checkAllDigitsValid(int[] digits) {
		for (int i = 0; i < digits.length; i++) {
			if (digits[i] < 0 || digits[i] >= 10) {
				return false;
			}
		}

		return true;
	}

	public static boolean verifyCreditCardChecksum(int[] digits) {
		int[] doubledValues = doubleEvenIndices(digits);
		int[] summedDigits = sumDigits(doubledValues);
		return sum(summedDigits) % 10 == 0;
	}

	public static int[] doubleEvenIndices(int[] digits) {
		int[] doubledValues = new int[digits.length];

		for (int i = 0; i < digits.length; i++) {
			if (i % 2 == 0) {
				doubledValues[i] = digits[i] * 2;
			} else {
				doubledValues[i] = digits[i];
			}
		}

		return doubledValues;
	}

	public static int[] sumDigits(int[] digits) {
		int[] summedDigits = new int[digits.length];

		for (int i = 0; i < digits.length; i++) {
			if (digits[i] < 10) {
				summedDigits[i] = digits[i];
			} else {
				summedDigits[i] = (digits[i] / 10) + (digits[i] % 10);
			}
		}

		return summedDigits;
	}

	public static int sum(int[] array) {
		int accumulate = 0;
		for (int i = 0; i < array.length; i++) {
			accumulate += array[i];
		}

		return accumulate;
	}
}
