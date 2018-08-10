package LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xurj@yintong.com.cn
 * @version V1.0
 * @Date 2018/8/8 17:21
 * @since JDK 1.6
 */
public class Solution {
	/**
	 * Given "abcabcbb", the answer is "abc", which the length is 3.
	 * <p>
	 * Given "bbbbb", the answer is "b", with the length of 1.
	 * <p>
	 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
	 *
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s) {
		int n = s.length();
		int ans = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0, j = 0; j < n; j++) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);
			}
			ans = Math.max(ans, j - i + 1);
			map.put(s.charAt(j), j + 1);
		}
		return ans;

	}

	public int returnLargeNum(int a, int b) {
		if (a > b) {
			return a;
		} else {
			return b;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.lengthOfLongestSubstring("abba"));
	}
}
