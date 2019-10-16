package TwoPointer;

class Solution {
	public void reverseString(char[] s) {
		int left = 0, right = s.length - 1;
		while (left < right) {
			char tmp = s[left];
			s[left++] = s[right];
			s[right--] = tmp;
		}
	}

	public void helper(char[] s, int left, int right) {
		if (left >= right)
			return;
		char tmp = s[left];
		s[left++] = s[right];
		s[right--] = tmp;
		helper(s, left, right);
	}

	public void reverseString2(char[] s) {
		helper(s, 0, s.length - 1);
	}
}
