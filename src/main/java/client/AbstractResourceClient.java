package client;

import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

public class AbstractResourceClient {


    protected  Client client = ClientBuilder.newClient();

    public Invocation.Builder addHeaders(Invocation.Builder builder, Map<String, String>headers) {

        if(headers != null) {
            for(Map.Entry<String, String>entry : headers.entrySet()) {
                builder = builder.header(entry.getKey(), entry.getValue());
            }

        }

        return builder;


    }

    public WebTarget addQueryParameters(WebTarget target, Map<String, String> queryParameters) {
        if(queryParameters != null) {
            for(Map.Entry<String, String> entry : queryParameters.entrySet()) {
                target = target.queryParam(entry.getKey(), entry.getValue());
            }

        }

        return target;

    }



}
