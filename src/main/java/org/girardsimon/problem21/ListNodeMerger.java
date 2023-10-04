package org.girardsimon.problem21;

import org.girardsimon.common.model.ListNode;

public final class ListNodeMerger {
    private ListNodeMerger() {
    }
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
