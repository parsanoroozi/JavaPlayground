package concurrency;
/**
 * 1) what are threads
 * 2) Interrupting threads
 * 3) Thread states
 * 4) Thread properties
 * 5) Synchronization
 * 6) Blocking Queues
 * 7) Thread-safe Collections
 * 8) Callables and Futures
 * 9) Executors
 * 10) Synchronizer
 * */
public class Main {
    /**
     * each process has a cpu for its own and own its different variables and data
     * but one single processor core can  run many thread in parallel(like the Round Robin strategy) and the risky part is that threads share variables and data
     * and exactly for this reason thread programming is more efficient than programming with many process cores(because of the overhead)
     *
     * Other than with the deprecated stop method, there is no way to force a thread to
     * terminate. However, the interrupt method can be used to request termination of
     * a thread.
     * */

    /**
     * Thread states:
     *  1)  New => first when you create a thread, but it hasn't run it yet
     *
     *  2)  Runnable => when you call the start method for the thread it's in the Runnable state
     *      Always keep in mind that a runnable thread may or may not be running at any
     *      given time. (This is why the state is called “runnable” and not “running.”)
     *
     *  3)  Blocked => When a thread is blocked or waiting, it is temporarily inactive. It doesn’t execute
     *      any code and consumes minimal resources. It is up to the thread scheduler to
     *      reactivate it + When the thread tries to acquire an intrinsic object lock that is currently held by another thread, it becomes
     *      blocked.
     *
     *  4)  Waiting => When a thread is blocked or waiting, it is temporarily inactive. It doesn’t execute
     *      any code and consumes minimal resources. It is up to the thread scheduler to
     *      reactivate it +  When the thread waits for another thread to notify the scheduler of a condition,
     *      it enters the waiting state
     *
     *  5)  Timed waiting => Several methods have a timeout parameter. Calling them causes the thread
     *      to enter the timed waiting state. This state persists either until the timeout expires or the
     *      appropriate notification has been received. Methods with timeout
     *      include "Thread.sleep" and the timed versions of "Object.wait", "Thread.join", Lock.tryLock,
     *      and Condition.await.
     *
     *  6)  Terminated
     *
     *
     * */
    public static void main(){
        System.out.println("concurrency main");
        Runnable run = ()->{
            try{
              for(int i = 0; i< 100; i++){
                  System.out.println("hello");
                  System.out.println(Thread.currentThread().getState());
                  System.out.println(Thread.currentThread().isInterrupted());
              }
            } catch(Exception e){
                System.out.println(e);
                Thread.currentThread().interrupt();
            }
        };
        Runnable run1 = ()->{
            try{
                for(int i = 0; i< 100; i++) {
                    System.out.println("1 run 1");
                    System.out.println(Thread.currentThread().getState());
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            } catch(Exception e){
                System.out.println(e);
                Thread.currentThread().interrupt();
            }
        };
        System.out.println(Thread.currentThread());
        System.out.println(Thread.currentThread().isInterrupted());
        Thread t = new Thread(run);
        Thread t1 = new Thread(run1);
        t.start();
        System.out.println(Thread.currentThread());
        System.out.println(Thread.currentThread().isInterrupted());
        t1.start();
        System.out.println(Thread.currentThread());
        System.out.println(Thread.currentThread().isInterrupted());
    }
}
