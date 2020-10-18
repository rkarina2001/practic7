package exercise1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PyanitsaLinkedList {
    private LinkedList<Integer> l1;
    private LinkedList<Integer> l2;
    private int step = 0;

    public PyanitsaLinkedList(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        this.l1 = l1;
        this.l2 = l2;
    }

    public String game() {
        while (step < 106  && !l1.isEmpty() && !l2.isEmpty()) {
            Integer previous1 = l1.remove();
            Integer previous2 = l2.remove();

            if (previous1 == 9 && previous2 == 0) {
                l2.add(previous2);
                l2.add(previous1);
            } else {
                if (previous2 == 9 && previous1 == 0) {
                    l1.add(previous1);
                    l1.add(previous2);
                } else {
                    if (previous1 < previous2) {
                        l2.add(previous2);
                        l2.add(previous1);
                    } else {
                        l1.add(previous1);
                        l1.add(previous2);
                    }
                }
            }
            step++;
        }
        if (step == 106) {
            return "botva";
        } else if (l1.isEmpty()) {
            return "second " + step;
        } else {
            return "first" + step;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            l1.add(scanner.nextInt());
        }
        for (int i = 0; i < 5; i++) {
            l2.add(scanner.nextInt());
        }
        PyanitsaLinkedList cards = new PyanitsaLinkedList(l1, l2);
        System.out.println(cards.game());
    }
}
