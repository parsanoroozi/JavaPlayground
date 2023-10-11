package concurrency;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private final double[] accounts;
    private Lock bankLock;
    private Condition sufficientFunds;

    public Bank(int n, double initialBalance)
    {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
        bankLock = new ReentrantLock();
        sufficientFunds = bankLock.newCondition();
    }

    /**
     * but actually the synchronized keyword before the method takes care of the whole thing that we implemented with locks and...
     * It is also legal to declare static methods as synchronized.
     * like bellow:
     *
     * class Bank
     * {
     *  private double[] accounts;
     *  public synchronized void transfer(int from, int to, int amount) throws InterruptedException
     *  {
     *  while (accounts[from] < amount)
     * wait(); // wait on intrinsic object lock's single condition
     *  accounts[from] -= amount;
     *  accounts[to] += amount;
     * notifyAll(); // notify all threads waiting on the condition
     *  }
     *  public synchronized double getTotalBalance() { . . . }
     * }
     *
     * The intrinsic locks and conditions have some limitations. Among them:
     * • You cannot interrupt a thread that is trying to acquire a lock.
     * • You cannot specify a timeout when trying to acquire a lock.
     * • Having a single condition per lock can be inefficient.
     *
     * • void notifyAll()
     * unblocks the threads that called wait on this object. This method can only be
     * called from within a synchronized method or block. The method throws an
     * IllegalMonitorStateException if the current thread is not the owner of the object’s lock.
     *
     * As we just discussed, every Java object has a lock. A thread can acquire the lock
     * by calling a synchronized method. There is a second mechanism for acquiring
     * the lock: by entering a synchronized block. When a thread enters a block of the form
     * synchronized (obj) // this is the syntax for a synchronized block
     * {
     * critical section
     * }
     * then it acquires the lock for obj
     *
     *
     * Locks and conditions are powerful tools for thread synchronization, but they are
     * not very object oriented. For many years, researchers have looked for ways to
     * make multithreading safe without forcing programmers to think about explicit
     * locks. One of the most successful solutions is the monitor concept
     * that was pioneered by Per Brinch Hansen and Tony Hoare in the 1970s. In the terminology
     * of Java, a monitor has these properties:
     * • A monitor is a class with only private fields.
     * • Each object of that class has an associated lock.
     * • All methods are locked by that lock. In other words, if a client calls obj.method(),
     * then the lock for obj is automatically acquired at the beginning of the method
     * call and relinquished when the method returns. Since all fields are private,
     * this arrangement ensures that no thread can access the fields while another
     * thread manipulates them.
     * • The lock can have any number of associated conditions
     *
     * The volatile keyword in Java is used to indicate that a variable's value
     * may be modified by multiple threads simultaneously.
     * It ensures that the variable is always read from and written to the main memory,
     * rather than from thread-specific caches, ensuring visibility across threads.
     *
     * 14.5.10 Atomics
     * You can declare shared variables as volatile provided you perform no operations
     * other than assignment.
     * There are a number of classes in the java.util.concurrent.atomic package that use efficient
     * machine-level instructions to guarantee atomicity of other operations without
     * using locks. For example, the AtomicInteger class has methods incrementAndGet and
     * decrementAndGet that atomically increment or decrement an integer
     *
     * 14.5.11 Deadlocks
     * Locks and conditions cannot solve all problems that might arise in multithreading.
     * Consider the following situation:
     * 1. Account 1: $200
     * 2. Account 2: $300
     * 3. Thread 1: Transfer $300 from Account 1 to Account 2
     * 4. Thread 2: Transfer $400 from Account 2 to Account 1
     * As Figure 14.6 indicates, Threads 1 and 2 are clearly blocked. Neither can proceed
     * because the balances in Accounts 1 and 2 are insufficient.
     * It is possible that all threads get blocked because each is waiting for more money.
     * Such a situation is called a deadlock.
     *
     * actually in multithreading we have local thread variables too.
     *
     * 14.5.14 Read/Write Locks
     * The java.util.concurrent.locks package defines two lock classes, the ReentrantLock that
     * we already discussed and the ReentrantReadWriteLock. The latter is useful when there
     * are many threads that read from a data structure and fewer threads that modify
     * it. In that situation, it makes sense to allow shared access for the readers. Of course,
     * a writer must still have exclusive access.
     *
     * A blocking queue causes a thread to block when you try to add an element when
     * the queue is currently full or to remove an element when the queue is empty.
     * Blocking queues are a useful tool for coordinating the work of multiple threads.
     * Worker threads can periodically deposit intermediate results into a blocking
     * queue. Other worker threads remove the intermediate results and modify them
     * further. The queue automatically balances the workload
     *
     * You can protect a shared data structure by supplying a lock, but it is usually
     * easier to choose a thread-safe implementation instead.
     *
     * A Runnable encapsulates a task that runs asynchronously; you can think of it as an
     * asynchronous method with no parameters and no return value. ACallable is similar
     * to a Runnable, but it returns a value. The Callable interface is a parameterized type,
     * with a single method call.
     *
     * A Future holds the result of an asynchronous computation. You can start a computation,
     * give someone the Future object, and forget about it. The owner of the Future
     * object can obtain the result when it is ready.
     */
    public void transfer(int from, int to, double amount) throws InterruptedException
    {
        bankLock.lock();
        try
        {
            while (accounts[from] < amount)
                sufficientFunds.await();
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
            sufficientFunds.signalAll();
        }
        finally
        {
            bankLock.unlock();
        }
    }

    public double getTotalBalance()
    {
        bankLock.lock();
        try
        {
            double sum = 0;

            for (double a : accounts)
                sum += a;

            return sum;
        }
        finally
        {
            bankLock.unlock();
        }
    }

    public int size()
    {
        return accounts.length;
    }
}
