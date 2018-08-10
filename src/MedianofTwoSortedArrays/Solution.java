package MedianofTwoSortedArrays;

/**
 * 时间复杂度：O(M+N)
 */
public class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int totalLength = nums1.length + nums2.length;
		int[] totalArray = new int[totalLength];
		int ans = 0;
		int i = 0, j = 0;
		while (i < nums1.length && j < nums2.length) {
			int a = nums1[i];
			int b = nums2[j];
			if (a > b) {
				totalArray[ans++] = b;
				j++;
			} else {
				totalArray[ans++] = a;
				i++;
			}
		}
		if (i < nums1.length) {
			for (; i < nums1.length; i++) {
				totalArray[ans++] = nums1[i];
			}
		} else if (j < nums2.length) {
			for (; j < nums2.length; j++) {
				totalArray[ans++] = nums2[j];
			}
		}
		// 最后得到排序完的数组 计算中位
		int num = totalLength / 2;
		int did = totalLength % 2;
		double mid = 0;
		if (did == 0) {
			mid = (totalArray[num] + totalArray[num - 1]) / 2.0;
		} else {
			mid = totalArray[num];
		}
		return mid;


	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
		;
	}
}
