package jp.mirageworld.algorithm.digit;

public class LuhnDigit {

	public boolean apply(String cardNumber) {

		StringBuilder number = new StringBuilder(cardNumber);
		if (cardNumber.length() < 19) {
			number.append("0".repeat(19 - cardNumber.length()));
		}
		char[] charArray = number.toString().toCharArray();

		boolean eve = true;
		int sum = 0;
		int index = 0;
		for (Character c : charArray) {
			index++;
			if (index < 19) {
				if (eve) {
					sum += (toInt(c) * 2) % 9;
				} else {
					sum += toInt(c);
				}
			}
			eve = !eve;
		}
		int a = sum % 10;
		int b = toInt(charArray[18]);
		if (a != b) {
			System.out.println(a);
			System.out.println(b);
		}
		return a == b;
	}

	private int toInt(char c) {
		return c - '0';
	}
}
