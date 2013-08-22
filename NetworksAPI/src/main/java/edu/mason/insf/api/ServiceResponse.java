package edu.mason.insf.api;

public class ServiceResponse {

    private Object data;
    private boolean success;
    private String message;

    public ServiceResponse()
    {
        super();
    }

    public ServiceResponse(Object data, boolean success, String message)
    {
        this.data = data;
        this.success = success;
        this.message = message;
    }

    public String getMessage()
    {
        return this.message;
    }

    public boolean getSuccess()
    {
        return this.success;
    }

    public Object getData()
    {
        return this.data;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public void setData(Object data)
    {
        this.data = data;
    }

    public void setSuccess(boolean success)
    {
        this.success = success;
    }
}
