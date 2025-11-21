class EvenThread extends Thread {
@Override
    public void run() {
        for (int i = 0; i <= 20; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
        System.out.println("Even numbers printed");
    }
}

class OddThread extends Thread {
@Override
    public void run() {
        for (int i = 1; i < 20; i += 2) {
            System.out.println(i);
        }
        System.out.println("Odd numbers printed");
    }
}

class Sum extends Thread {
@Override
    public void run() {
        int sum = 0;
        for (int i = 0; i <= 20; i++) {
            sum += i;
        }
        System.out.println(sum);
        System.out.println("Sum of numbers printed");
    }
}

public class multithread {

    public static void main(String[] args) {
        new EvenThread().start();
        new OddThread().start();
        new Sum().start();
    }
}