package org.girardsimon.problem2;

import org.girardsimon.common.model.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ListNodeAddTest {
    private static Stream<Arguments> listNodes() {
        //[2,4,3]
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(4, listNode1);
        ListNode listNode3 = new ListNode(2, listNode2);
        //[5,6,4]
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(6, listNode4);
        ListNode listNode6 = new ListNode(5, listNode5);
        //[7,0,8]
        ListNode listNode7 = new ListNode(8);
        ListNode listNode8 = new ListNode(0, listNode7);
        ListNode listNode9 = new ListNode(7, listNode8);

        //[9,9,9,9,9,9,9]
        ListNode listNode10 = new ListNode(9);
        ListNode listNode11 = new ListNode(9, listNode10);
        ListNode listNode12 = new ListNode(9, listNode11);
        ListNode listNode13 = new ListNode(9, listNode12);
        ListNode listNode14 = new ListNode(9, listNode13);
        ListNode listNode15 = new ListNode(9, listNode14);
        ListNode listNode16 = new ListNode(9, listNode15);
        //[9,9,9,9]
        ListNode listNode18 = new ListNode(9);
        ListNode listNode19 = new ListNode(9, listNode18);
        ListNode listNode20 = new ListNode(9, listNode19);
        ListNode listNode21 = new ListNode(9, listNode20);
        //[8,9,9,9,0,0,0,1]
        ListNode listNode22 = new ListNode(1);
        ListNode listNode23 = new ListNode(0, listNode22);
        ListNode listNode24 = new ListNode(0, listNode23);
        ListNode listNode25 = new ListNode(0, listNode24);
        ListNode listNode26 = new ListNode(9, listNode25);
        ListNode listNode27 = new ListNode(9, listNode26);
        ListNode listNode28 = new ListNode(9, listNode27);
        ListNode listNode29 = new ListNode(8, listNode28);


        return Stream.of(
                //[2,4,3] + [5,6,4] -> [7,)$
    Arguments.of(listNode3, listNode6, listNode9),
                //[0] + [0] -> [0]
                Arguments.of(new ListNode(0), new ListNode(0), new ListNode(0)),
                //[9,9,9,9,9,9,9] + [9,9,9,9] -> [8,9,9,9,0,0,0,1]
                Arguments.of(listNode16, listNode21, listNode29)
        );
    }
    @ParameterizedTest
    @MethodSource("listNodes")
    void addTwoNumbers_should_return_a_ListNode_that_is_the_sum_of_the_two_inputs(ListNode left, ListNode right,
                                                          ListNode expected) {
        // Act
        ListNode actual = ListNodeAdd.addTwoNumbers(left, right);

        // Assert
        assertThat(actual).isEqualTo(expected);
    }
}