package com.karlin.testing.acceptance.test.glue.client;


import javax.ws.rs.core.Response;
import client.GetClient;
import com.karlin.testing.acceptance.test.glue.Client;
import com.karlin.testing.acceptance.test.glue.specs.GetClientSpecification;

public class GetTestClient implements Client {

    private GetClientSpecification specification;

    public GetTestClient(GetClientSpecification specification) {

        this.specification = specification;
    }

    @Override
    public Response makeRequest(){
        if (specification.getId() != null) {
            return new GetClient().getDatabyID(
                    specification.getBaseUri(),
                    specification.getAcceptType(),
                    specification.getHeaders(),
                    specification.getId()
            );
        } else {
            return new GetClient().getList(
                    specification.getBaseUri(),
                    specification.getAcceptType(),
                    specification.getHeaders()
            );

        }

    }
}
