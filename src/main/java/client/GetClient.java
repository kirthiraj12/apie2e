package client;

import javax.print.attribute.standard.Media;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

public class GetClient extends AbstractResourceClient {

    public Response getList(String baseUri, MediaType acceptType, Map<String, String> headers) {
        WebTarget target = client
                .target(baseUri)
                .path("/posts");

        Invocation.Builder builder = target.request(acceptType);

        builder = addHeaders(builder, headers);

        return  builder.get();

    }

    public Response getDatabyID(String baseUri, MediaType acceptType,Map<String, String> headers, String id){

        WebTarget target = client
                .target(baseUri)
                .path("/posts")
                .path(id);
        Invocation.Builder builder = target.request(acceptType);

        builder = addHeaders(builder , headers);

        return builder.get();

    }


}
