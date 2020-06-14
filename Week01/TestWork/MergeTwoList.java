package examsTest.TestWork;

/**
 * @program: algorithm
 * @description: 合并两个列表
 * @author: wuzheb
 * @create: 2020-06-13 22:45
 **/
public class MergeTwoList {



    /**
     * 递归法，每一次选出最小节点
     *
     * @Author             wuzhen
     * @Description
     * @Date              2020/6/13 23:08
     * @Param             [l1, l2]
     * @return            examsTest.TestWork.MergeTwoList.ListNode
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }


    /**
     * 迭代法， 每一代选出新的前节点
     *
     * @Author             wuzhen
     * @Description
     * @Date              2020/6/13 23:09
     * @Param             [l1, l2]
     * @return            examsTest.TestWork.MergeTwoList.ListNode
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(-1);

        ListNode pre = head;

        while (l1 != null && l2 != null) {


            if (l1.val <= l2.val) {

                pre.next = l1;

                l1 = l1.next;
            } else {

                pre.next = l2;

                l2 = l2.next;
            }

            pre = pre.next;

        }


        pre.next = l1 == null ? l2 : l1;

        return head.next;


    }

    public class ListNode {

        private ListNode next;

        private int val;


        ListNode(int value) {

            this.val = value;

        }


    }



}
