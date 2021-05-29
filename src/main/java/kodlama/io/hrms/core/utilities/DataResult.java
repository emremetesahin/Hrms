package kodlama.io.hrms.core.utilities;

public class DataResult<T> extends Result {
	private T data;

	public DataResult(T data,Boolean success) {
		super(success);
		this.data=data;
	}
	public DataResult(T data,Boolean success,String message)
	{
		super(success,message);
		this.data=data;
	}

	public T getData()
	{
		return this.data;
	}
}
