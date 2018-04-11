package com.karlin.testing.acceptance.test.glue.specs;

import com.karlin.testing.acceptance.test.glue.ClientSpecification;

public class GetClientSpecification extends ClientSpecification<GetClientSpecification> {

    private String id;

    public static GetClientSpecification create() {
        return new GetClientSpecification();

    }

    public GetClientSpecification withId(String id) {
        return new GetClientSpecification();
    }

    public  String getId() {return id; }

    @Override
    public String toString() {
        return "clientSpecification{" +
                "id = " + super.toString() +
                '}';

    }

}
