package thread;

public class AutoUpdateThread extends Thread {
    public void run() {
        while(true){
            try {
                System.out.println("Auto updating data...");
                Thread.sleep(5000);
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
