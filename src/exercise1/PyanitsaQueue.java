package exercise1;

import java.util.Scanner;
import java.util.*;

public class PyanitsaQueue {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    private int step = 0;

    public PyanitsaQueue(Queue<Integer> q1, Queue<Integer> q2) {
        this.q1 = q1;
        this.q2 = q2;
    }

    public String game() {
        while (step < 106  && !q1.isEmpty() && !q2.isEmpty()) {
            Integer previous1 = q1.remove();
            Integer previous2 = q2.remove();

            if (previous1 == 9 && previous2 == 0) {
                q2.add(previous2);
                q2.add(previous1);
            } else {
                if (previous2 == 9 && previous1 == 0) {
                    q1.add(previous1);
                    q1.add(previous2);
                } else {
                    if (previous1 < previous2) {
                        q2.add(previous2);
                        q2.add(previous1);
                    } else {
                        q1.add(previous1);
                        q1.add(previous2);
                    }
                }
            }
            step++;
        }
        if (step == 106) {
            return "botva";
        } else if (q1.isEmpty()) {
            return "second " + step;
        } else {
            return "first" + step;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();
        for (int i = 0; i < 5; i++) {
            q1.add(scanner.nextInt());
        }
        for (int i = 0; i < 5; i++) {
            q2.add(scanner.nextInt());
        }
        PyanitsaQueue cards = new PyanitsaQueue(q1, q2);
        System.out.println(cards.game());
    }
}
