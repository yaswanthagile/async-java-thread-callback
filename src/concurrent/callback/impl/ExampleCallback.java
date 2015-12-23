package concurrent.callback.impl;

import concurrent.callback.Callback;

public class ExampleCallback<T> implements Callback<T>
{

    @Override
    public void callback(T t)
    {
	System.out.println(t);
	// TODO Auto-generated method stub
    }
}
