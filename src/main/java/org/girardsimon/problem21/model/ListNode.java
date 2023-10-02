package org.girardsimon.problem21.model;

import java.util.Objects;

public class ListNode {
    private int val;
    private ListNode next;

    public ListNode() {
    }
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int val() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode next() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val && Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
