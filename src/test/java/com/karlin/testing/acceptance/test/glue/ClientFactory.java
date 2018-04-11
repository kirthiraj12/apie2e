package com.karlin.testing.acceptance.test.glue;

import com.karlin.testing.acceptance.test.glue.client.GetTestClient;
import com.karlin.testing.acceptance.test.glue.specs.GetClientSpecification;

import org.springframework.stereotype.Component;

@Component
public class ClientFactory {


    //private String baseuri;

    private String baseuri = "https://jsonplaceholder.typicode.com";

    public void setBaseUri(ClientSpecification specification) {
        specification.withBaseUri(baseuri);
    }

    public Client getClientFor(ClientSpecification specification) {
        setBaseUri(specification);

        switch (specification.getPath()){
            case "/posts":
            return new GetTestClient((GetClientSpecification) specification);
            default:
                throw new IllegalStateException("specification does not map to a client" + specification);

        }


    }
}






