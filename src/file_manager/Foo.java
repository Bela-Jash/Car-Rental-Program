package file_manager;

import java.io.Serial;
import java.io.Serializable;

class Foo implements Serializable
{
    @Serial
    private static final long serialVersionUID = 1L;
    private String data;
    private double size;

    public Foo(String data, double size)
    {
        this.data = data;
        this.size = size;
    }

    public String getData()
    {
        return data;
    }

    public double getSize()
    {
        return size;
    }

    public void setData(String data)
    {
        this.data = data;
    }

    public void setSize(double size)
    {
        this.size = size;
    }
}