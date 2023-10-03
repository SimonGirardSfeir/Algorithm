package org.girardsimon.problem21;

import org.girardsimon.problem21.model.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ListNodeResolverTest {
    private static Stream<Arguments> listNodes() {
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(2, listNode1);
        ListNode listNode3 = new ListNode(1, listNode2);

        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(3, listNode4);
        ListNode listNode6 = new ListNode(1, listNode5);

        ListNode listNode7 = new ListNode(4);
        ListNode listNode8 = new ListNode(4, listNode7);
        ListNode listNode9 = new ListNode(3, listNode8);
        ListNode listNode10 = new ListNode(2, listNode9);
        ListNode listNode11 = new ListNode(1, listNode10);
        ListNode listNode12 = new ListNode(1, listNode11);
        return Stream.of(
                Arguments.of(listNode3, listNode6, listNode12),
                Arguments.of(null, null, null),
                Arguments.of(null, new ListNode(0), new ListNode(0))
        );
    }
    @ParameterizedTest
    @MethodSource("listNodes")
    void mergeTwoLists_should_merge_two_ListNode_into_one(ListNode left, ListNode right,
                                                          ListNode expected) {
        // Act
        ListNode actual = ListNodeResolver.mergeTwoLists(left, right);

        // Assert
        assertThat(actual).isEqualTo(expected);
    }

}