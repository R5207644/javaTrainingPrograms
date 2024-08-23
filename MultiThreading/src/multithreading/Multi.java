
package multithreading;

//public class Multi implements Runnable {
//    public void run() {
//        for (int i= 0; i < 5; i++) {
//            System.out.println("Thread - " + i);
//        }
//    }
//    
//    public static void main(String[] args) {
//        Multi m1 = new Multi();
//        Thread t1 = new Thread(m1);
//        t1.start();
//    }
//}

public class Multi extends Thread {
    
    // defining thread task
    
    @Override
    @SuppressWarnings({"SleepWhileInLoop", "UseSpecificCatch"})
    public void run() {
        
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
            
            // applying sleep method to add delay
            
            try {
                Thread.sleep(1000);
            } catch(Exception ex) {
                System.out.println(ex);
            }
        }
        
    }
   
    @SuppressWarnings("UseSpecificCatch")
    public static void main(String[] args) {
        
        Multi t1 = new Multi();
        Multi t2 = new Multi();
        Multi t3 = new Multi();
        
        
        t1.setPriority(MIN_PRIORITY);
        t2.setPriority(MAX_PRIORITY);
       
        t1.start();
        
       
        
        t2.start();
        t3.start();
 
    }
    
}
