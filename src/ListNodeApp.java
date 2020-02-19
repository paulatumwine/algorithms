public class ListNodeApp {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        Solution solution = new Solution();
        ListNode node = solution.addTwoNumbers(l1, l2);
        System.out.println(solution.printList(node));

        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(5);
        node = solution.addTwoNumbers(l3, l4);
        System.out.println(solution.printList(node));

        ListNode l5 = new ListNode(0);
        ListNode l6 = new ListNode(0);
        node = solution.addTwoNumbers(l5, l6);
        System.out.println(solution.printList(node));

        ListNode l7 = new ListNode(9);
        l7.next = new ListNode(8);
        ListNode l8 = new ListNode(1);
        node = solution.addTwoNumbers(l7, l8);
        System.out.println(solution.printList(node));

        ListNode l9 = new ListNode(1);
        l9.next = new ListNode(8);
        ListNode l10 = new ListNode(0);
        node = solution.addTwoNumbers(l9, l10);
        System.out.println(solution.printList(node));
    }
}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return String.format("%d", val);
    }
}

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static boolean isPalindromic(String s) {
        for (int i = 0, j = s.length() - 1; i < j; ++i , --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        if (l1.val == 0 && l2.val == 0)
            return new ListNode(0);

        if (l1.next != null && l2.next == null) {
            ListNode sum = new ListNode(l1.val + l2.val);
            if (sum.val >= 10) {
                sum.val = sum.val - 10;
                sum.next = new ListNode(1 + l1.next.val);
                return sum;
            } else {
                l1.val = sum.val;
                return l1;
            }
        }

        if (l2.next != null && l1.next == null) {
            ListNode sum = new ListNode(l1.val + l2.val);
            if (sum.val >= 10) {
                sum.val = sum.val - 10;
                sum.next = new ListNode(1 + l2.next.val);
                return sum;
            } else {
                l2.val = sum.val;
                return l2;
            }
        }

        if (l1.next == null && l2.next == null) {
            ListNode sum = new ListNode(l1.val + l2.val);
            if (sum.val >= 10) {
                sum.val = sum.val - 10;
                sum.next = new ListNode(1);
            }
            return sum;
        }

        ListNode sum = addTwoNumbers(l1.next, l2.next);
        if (sum.next != null && sum.next.val >= 10) {
            ListNode res = new ListNode(sum.next.val - 10);
            res.next = new ListNode(1 + l1.val + l2.val);
            sum.next = res;
            return sum;
        }
        else {
            ListNode res = sum;
            res.next = new ListNode(l1.val + l2.val);
            return res;
        }
    }

    String printList(ListNode listNode) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("[");
         while (listNode != null) {
             buffer.append(listNode.val);
             listNode = listNode.next;
         }
        buffer.append("]");
        return buffer.toString();
    }
}
