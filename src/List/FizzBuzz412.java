package List;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

/**
 * @author he.wu Write a program that outputs the string representation of
 *         numbers from 1 to n.
 * 
 *         But for multiples of three it should output “Fizz” instead of the
 *         number and for the multiples of five output “Buzz”. For numbers which
 *         are multiples of both three and five output “FizzBuzz”.
 * 
 *         Example:
 * 
 *         n = 15,
 * 
 *         Return: [ "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz",
 *         "Buzz", "11", "Fizz", "13", "14", "FizzBuzz" ]
 */
public class FizzBuzz412 {
	public List<String> fizzBuzz(int n) {
		List<String> res = new ArrayList<String>();
		if (n <= 0)
			return res;
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 == 0)
				res.add("FizzBuzz");
			else if (i % 3 == 0)
				res.add("Fizz");
			else if (i % 5 == 0)
				res.add("Buzz");
			else
				res.add(Integer.toString(i));
		}
		return res;
	}

	// hash
	public List<String> fizzBuzz2(int n) {
		// ans list
		List<String> ans = new ArrayList<String>();
		// Hash map to store all fizzbuzz mappings.
		HashMap<Integer, String> fizzBizzDict = new HashMap<Integer, String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				put(3, "Fizz");
				put(5, "Buzz");
			}
		};
		for (int num = 1; num <= n; num++) {
			String numAnsStr = "";
			for (Integer key : fizzBizzDict.keySet()) {
				// If the num is divisible by key,
				// then add the corresponding string mapping to current numAnsStr
				if (num % key == 0) {
					numAnsStr += fizzBizzDict.get(key);
				}
			}
			if (numAnsStr.equals("")) {
				// Not divisible by 3 or 5, add the number
				numAnsStr += Integer.toString(num);
			}
			// Append the current answer str to the ans list
			ans.add(numAnsStr);
		}
		return ans;
	}

	@Test
	public void test() {
		int n = 15;
		System.out.println(fizzBuzz2(n));
	}
}
