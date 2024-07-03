package code_practice.ubs;
class Increment {
    private int count = 0;

    public void increment() {
        for(int i = 0; i < 1000000; i++){
            count = count + 1;
        }
    }

    public int getCount() {
        return this.count;
    }
}

public class Concurrent {

    public static void main(String[] args) {
        Increment eg = new Increment();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(eg::increment);
            thread.start();
        }
        System.out.println(eg.getCount());
    }
}
