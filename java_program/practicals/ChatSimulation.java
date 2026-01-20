class ChatUser extends Thread {
    private String userName;
    private volatile boolean suspended = false;
    private volatile boolean stopped = false;

    ChatUser(String name) {
        this.userName = name;
    }

    public void run() {
        try {
            int count = 1;
            while (!stopped) {
                synchronized (this) {
                    while (suspended) {
                        wait();
                    }
                }
                System.out.println(userName + " says: Message " + count);
                count++;
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(userName + " interrupted.");
        }
    }

    public synchronized void suspendThread() {
        suspended = true;
    }

    public synchronized void resumeThread() {
        suspended = false;
        notify();
    }

    public void stopThread() {
        stopped = true;
    }
}

public class ChatSimulation {
    public static void main(String[] args) {
        ChatUser user1 = new ChatUser("User1");
        ChatUser user2 = new ChatUser("User2");

        user1.setPriority(Thread.MAX_PRIORITY); // High priority
        user2.setPriority(Thread.MIN_PRIORITY); // Low priority

        user1.start();
        user2.start();

        try {
            System.out.println("User1 alive? " + user1.isAlive());
            System.out.println("User2 alive? " + user2.isAlive());

            Thread.sleep(3000);
            user1.suspendThread();
            System.out.println("User1 suspended.");

            Thread.sleep(3000);
            user1.resumeThread();
            System.out.println("User1 resumed.");

            Thread.sleep(3000);
            user1.stopThread();
            user2.stopThread();

            user1.join();
            user2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Chat simulation ended.");
    }
}
