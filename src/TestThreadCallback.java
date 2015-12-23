import java.util.concurrent.Callable;

import concurrent.ThreadRunner;
import concurrent.callback.Callback;

public class TestThreadCallback
{
    public static void main(String[] args)
    {
	ThreadRunner<String> r = new ThreadRunner<String>(new OurAsyncTask<String>("hello"), new Callback<String>()
	{
	    public void callback(String t)
	    {
		System.out.println(t + " Yaswanth");
	    };
	});

	Thread t = new Thread(r);
	t.start();
    }
}

/**
 * Test callable tas with 5seconds wait
 * 
 * @author yaswanth
 *
 * @param <V>
 */
class OurAsyncTask<V> implements Callable<V>
{

    V v;

    OurAsyncTask(V v)
    {
	this.v = v;
    }

    private synchronized void sleepForSomeTime()
    {
	try
	{
	    Thread.sleep(5000l);
	}
	catch (InterruptedException e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    @Override
    public V call() throws Exception
    {
	sleepForSomeTime();
	// TODO Auto-generated method stub
	return v;
    }
}
