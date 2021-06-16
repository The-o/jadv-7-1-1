package ru.netology.pyas;

public class BabblingThread extends Thread {

    private long timeout;

    public BabblingThread(ThreadGroup group, String name, long timeout) {
        super(group, name);
        this.timeout = timeout;
    }

    @Override
    public void run() {
        try {
            while(!isInterrupted()) {
                Thread.sleep(timeout);
                System.out.println(getName() + ": Всем привет!");
            }
        } catch (InterruptedException err) {
        } finally{
            System.out.println(getName() + " завершен");
        }
    }

}
