package exercise1;

import java.util.Stack;
import java.util.Scanner;

public class PyanitsaStack {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    private int step = 0;

    public PyanitsaStack(Stack<Integer> s1, Stack<Integer> s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    public String game() {
        while (step < 106  && !s1.isEmpty() && !s2.isEmpty()) {
            Integer previous1 = s1.pop();
            Integer previous2 = s2.pop();

            if (previous1 == 9 && previous2 == 0) {
                s2.push(previous2);
                s2.push(previous1);
            } else {
                if (previous2 == 9 && previous1 == 0) {
                    s1.push(previous1);
                    s1.push(previous2);
                } else {
                    if (previous1 < previous2) {
                        s2.push(previous2);
                        s2.push(previous1);
                    } else {
                        s1.push(previous1);
                        s1.push(previous2);
                    }
                }
            }
            step++;
        }
        if (step == 106) {
            return "botva";
        } else if (s1.isEmpty()) {
            return "second " + step;
        } else {
            return "first" + step;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        for (int i = 0; i < 5; i++) {
            s1.add(scanner.nextInt());
        }
        for (int i = 0; i < 5; i++) {
            s2.add(scanner.nextInt());
        }
        PyanitsaStack cards = new PyanitsaStack(s1, s2);
        System.out.println(cards.game());
    }
}
