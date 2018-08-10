package addTwoNumbers;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		ListNode finalNode = new ListNode(0);
		ListNode returnNode = finalNode;
		int nextAddNum = 0;
		while (l1 != null) {
			int l1num = l1.val;
			// 判断下 l2 是否为空
			int l2num = 0;
			if (l2 != null) {
				l2num = l2.val;
				l2 = l2.next;
			}
			int sum = l1num + l2num + nextAddNum;
			// 低位直接存储列表
			int lowBit = sum % 10;
			// 高位需要进到下一次再相加
			int highBit = sum / 10;
			finalNode.next = new ListNode(lowBit);
			finalNode = finalNode.next;
			nextAddNum = highBit;
			l1 = l1.next;
		}
		// 再次循环剩余的l2
		while (l2 != null) {
			int sum = l2.val + nextAddNum;
			l2 = l2.next;
			// 低位直接存储列表
			int lowBit = sum % 10;
			// 高位需要进到下一次再相加
			int highBit = sum / 10;
			finalNode.next = new ListNode(lowBit);
			finalNode = finalNode.next;
			nextAddNum = highBit;
		}
		if (nextAddNum != 0) {
			finalNode.next = new ListNode(nextAddNum);
		}

		return returnNode.next;
	}

	public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = l1, q = l2, curr = dummyHead;
		int carry = 0;
		while (p != null || q != null) {
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;
//			curr.next = new ListNode(sum % 10);
			curr.val = sum % 10;
			ListNode listNode = new ListNode(0);
			listNode.next = curr;
			curr = listNode;
			if (p != null) p = p.next;
			if (q != null) q = q.next;
		}
		if (carry > 0) {
			curr.val = carry;
		}
		return curr;
	}

	public static void main(String[] args) {
		/**
		 * [2,4,3]
		 * [5,6,4]
		 */
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		System.out.println(addTwoNumbers1(l1, l2));

//		ListNode l1 = new ListNode(0);
//
//		ListNode l2 = new ListNode(1);
//		System.out.println(addTwoNumbers(l1, l2));


	}
}