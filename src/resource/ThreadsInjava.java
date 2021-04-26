package resource;

public class ThreadsInjava{
    public static void main(String[] args) throws InterruptedException {
        BattingThread battingThread1 = new BattingThread();
        battingThread1.setDaemon(true);
        BowlingThread bownlingThread = new BowlingThread();
        Thread bowlingThread2 = new Thread(bownlingThread);
        bowlingThread2.setPriority(Thread.MAX_PRIORITY);
        battingThread1.setPriority(Thread.MIN_PRIORITY);

        System.out.println("current state of batting thread is " + battingThread1.getState());
        battingThread1.setName("batting Thread ");
        System.out.println("********************************** " + battingThread1.getName());
        battingThread1.start();
//        try {
//            battingThread1.join();
//        } catch(InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("current state of batting thread is " + battingThread1.getState());
        bowlingThread2.start();
    }

    static class BattingThread extends Thread {
        public void run() {
            for(int i=1;i<101;i++) {
                if(i == 50) {
                    try {
                        sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("This is from Batting Thread "+i);
                if(Thread.currentThread().isDaemon()){//checking for daemon thread
                    System.out.println("daemon thread work");
                }
                else{
                    System.out.println("user thread work");
                }
            }
        }
    }

    static class BowlingThread implements Runnable {
        @Override
        public void run() {
            for(int i=1;i<100;i++) {
                System.out.println("***** This is from Bowling Thread "+i);
            }
        }
    }

}
