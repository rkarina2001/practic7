package exercise1;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PyanitsaDeque {
    private ArrayDeque<Integer> dq1;
    private ArrayDeque<Integer> dq2;
    private int step = 0;

    public PyanitsaDeque(ArrayDeque<Integer> dq1, ArrayDeque<Integer> dq2) {
        this.dq1 = dq1;
        this.dq2 = dq2;
    }

    public String game() {
        while (step < 106  && !dq1.isEmpty() && !dq2.isEmpty()) {
            Integer previous1 = dq1.poll();
            Integer previous2 = dq2.poll();

            if (previous1 == 9 && previous2 == 0) {
                dq2.add(previous2);
                dq2.add(previous1);
            } else {
                if (previous2 == 9 && previous1 == 0) {
                    dq1.add(previous1);
                    dq1.add(previous2);
                } else {
                    if (previous1 < previous2) {
                        dq2.add(previous2);
                        dq2.add(previous1);
                    } else {
                        dq1.add(previous1);
                        dq1.add(previous2);
                    }
                }
            }
            step++;
        }
        if (step == 106) {
            return "botva";
        } else if (dq1.isEmpty()) {
            return "second " + step;
        } else {
            return "first" + step;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> dq1 = new ArrayDeque<Integer>();
        ArrayDeque<Integer> dq2 = new ArrayDeque<Integer>();
        for (int i = 0; i < 5; i++) {
            dq1.add(scanner.nextInt());
        }
        for (int i = 0; i < 5; i++) {
            dq2.add(scanner.nextInt());
        }
        PyanitsaDeque cards = new PyanitsaDeque(dq1, dq2);
        System.out.println(cards.game());
    }
}
