package com.karlin.testing.acceptance.test.glue;

import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

public class ClientSpecification<T extends ClientSpecification> {

    protected String baseUri;
    protected String path;
    protected MediaType acceptType;
    protected MediaType contentType;
    protected String  userGroup;

    protected Map<String, String> queryParmeters = new HashMap<>();
    protected Map<String, String> headers = new HashMap<>();

    public  static  ClientSpecification create() {return new ClientSpecification();}

    public T withPath(String path) {
        this.path = path;
        return (T) this;

    }

    public T withAcceptType(MediaType acceptType) {
        this.acceptType = acceptType;
        return (T) this;

    }

    public T withContentType(MediaType acceptType) {
        this.contentType = acceptType;
        return  (T) this;

    }

    public T withQueryParameters(Map<String, String> queryParameters){
        this.queryParmeters.putAll(queryParameters);
        return (T) this;

    }


    public T withHeaders(Map<String, String> headers) {
        this.headers.putAll(headers);
        return (T) this;

    }

    public T withBaseUri(String baseUri){
        this.baseUri= baseUri;
        return (T) this;

    }


    public String getBaseUri() {return  baseUri; }

    public String getPath(){return path;}

    public MediaType getAcceptType() {return acceptType;}

    public MediaType getContentType() {return contentType;}

    public Map<String, String> getQueryParmeters() {return queryParmeters;}

    public Map<String, String> getHeaders() {return headers;}

    public String getUserGroup() {return userGroup;}


    @Override
    public  String toString() {
        return "CilentSpecification{" +
                "baseUri=' " + baseUri + '\'' +
                ", path=' " + path + '\'' +'}';


    }



    }





