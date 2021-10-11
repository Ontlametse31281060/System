package za.ac.nwu.ac.domain.service;

import java.io.Serializable;
import java.util.Objects;

public class Response<T> implements Serializable
{
    private transient T payload;
    private boolean success;

    public Response(boolean success, T payload)
    {
        this.success = success;
        this.payload = payload;
    }

    public boolean isSuccess(){return success;}

    public T getPayload(){return payload;}

    @Override
    public boolean equals (Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        Response<?> that = (Response<?>) o;
        return success == that.success && Objects.equals(payload, that.payload);

    }

    @Override
    public int hashCode() {return Objects.hash(success, payload);}

    @Override
    public String toString()
    {
        return "Response{" +
                "Success= " + success +
                "Payload= " + payload +
                '}';
    }
}

