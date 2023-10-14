package org.girardsimon.problem21;

import org.girardsimon.common.model.ListNode;

public final class ListNodeMerger {
    private ListNodeMerger() {
    }
    /**
     * Merges two linked lists into a single sorted linked list.
     * <p>
     * Constraints:<br>
     * • The number of nodes in each linked list is in the range [1, 50].<br>
     * • -100 ≤ Node.val ≤ 100<br>
     * • Both linked lists are sorted in non-decreasing order.<br>
     *
     * @param left  The head node of the first linked list.
     * @param right The head node of the second linked list.
     * @return The head node of the merged linked list.
     */
    public static ListNode mergeTwoLists(ListNode left, ListNode right) {
        ListNode startingNode = new ListNode(0);
        ListNode current = startingNode;

        while(left != null || right != null) {
            if(right == null || (left != null && left.val() < right.val())) {
                current.setNext(left);
                left = left.next();
            } else {
                current.setNext(right);
                right = right.next();
            }
            current = current.next();
        }
        return startingNode.next();
    }
}
