package bytedance.codetop;

import org.example.hot100.listNode.ListNode;

import java.util.List;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/28 16:09
 */
public class TrainingPlan {

    public TrainingPlan() {
    }

    public ListNode trainingPlan(ListNode head, int cnt) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < cnt; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

}
