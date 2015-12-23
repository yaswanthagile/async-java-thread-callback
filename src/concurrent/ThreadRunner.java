package concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import concurrent.callback.Callback;

/**
 * Calling start will instantiate thread pool of size 5 (hardcoded)
 * 
 * @author yaswanth
 *
 * @param <T>
 */
public class ThreadRunner<T> extends FutureTask<T>
{
    private static final ExecutorService service = Executors.newFixedThreadPool(5);
    Callback<T> callback;

    public void start()
    {
	service.submit(this);

    }

    public ThreadRunner(Callable<T> callable, Callback<T> callback)
    {
	super(callable);
	this.callback = callback;
	// TODO Auto-generated constructor stub
    }

    @Override
    protected void done()
    {
	// TODO Auto-generated method stub
	super.done();
	if (callback != null)
	    try
	    {
		callback.callback(this.get());
	    }
	    catch (InterruptedException e)
	    {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	    catch (ExecutionException e)
	    {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
    }

}