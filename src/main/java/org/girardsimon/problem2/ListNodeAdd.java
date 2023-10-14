package org.girardsimon.problem2;

import org.girardsimon.common.model.ListNode;

import static org.girardsimon.common.utils.Constants.DECIMAL;

public final class ListNodeAdd {
    private ListNodeAdd() {
    }
    /**
     * Adds two numbers represented as ListNode objects. Digits are stored in reverse order.
     * <p>
     * Constraints:<br>
     * • The number of nodes in each linked list is in the range [1, 100].<br>
     * • 0 ≤ Node.val ≤ 9<br>
     * • It is guaranteed that the list represents a number that does not have leading zeros.<br>
     *
     * @param left  The first number represented as a ListNode.
     * @param right The second number represented as a ListNode.
     * @return The sum of the two numbers as a ListNode.
     */
    public static ListNode addTwoNumbers(ListNode left, ListNode right) {
        ListNode startingNode = new ListNode(0);
        ListNode current = startingNode;
        int add = 0;
        while((left != null || right != null) || add != 0) {

            int leftSide = left != null ? left.val() : 0;
            int rightSide = right != null ? right.val() : 0;
            int tempSum = leftSide + rightSide + add;
            current.setNext(new ListNode(tempSum % DECIMAL));
            if(tempSum >= DECIMAL)
                add = 1;
            else
                add = 0;

            if(left != null)
                left = left.next();
            if(right != null)
                right = right.next();
            current = current.next();
        }
        return startingNode.next();
    }

}
