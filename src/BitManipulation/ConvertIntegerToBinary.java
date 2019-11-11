package BitManipulation;

public class ConvertIntegerToBinary {
	public static void main(String[] args) {
		int i = 10;
		System.out.println(intToBinary(i));
		System.out.println(intToBit32(i));

	}

	// convert decimal to binary
	public static String intToBinary(int n) {
		String s = "";
		while (n > 0) {
			s = ((n % 2) == 0 ? "0" : "1") + s;
			n = n / 2;
		}
		return s;
	}

	public static String intToBit32(int n) {
		int[] bit = new int[32];
		int index = bit.length - 1;
		while (n > 0) {
			bit[index] = n % 2;
			index--;
			n /= 2;
		}
		return bit.toString();
	}
}
