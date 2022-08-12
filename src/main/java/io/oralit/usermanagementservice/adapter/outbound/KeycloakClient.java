package io.oralit.usermanagementservice.adapter.outbound;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.*;
import io.oralit.usermanagementservice.response.AccessTokenResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class KeycloakClient {

    @Value("${keycloak.admin.endpoint.token}")
    private String adminTokenUrl;

    @Value("${keycloak.admin.client.id}")
    private String adminClientId;

    @Value("${keycloak.admin.client.secret}")
    private String adminClientSecret;

    @Value("${keycloak.normal.endpoint.token}")
    private String normalTokenUrl;

    @Value("${keycloak.normal.client.id}")
    private String normalClientId;

    @Value("${keycloak.normal.client.scope}")
    private String normalClientScope;



    private static final Logger logger = LoggerFactory.getLogger(KeycloakClient.class);


    public AccessTokenResponse getAdminAccessToken() throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "grant_type=client_credentials&client_id="+adminClientId+"&client_secret="+adminClientSecret);
        Request request = new Request.Builder()
                .url(adminTokenUrl)
                .post(body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();

        Response response = client.newCall(request).execute();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(response.body().string(), AccessTokenResponse.class);
    }

    public AccessTokenResponse getUserAccessToken(String msisdn, String password) throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "grant_type=password&username="+msisdn+"&password="+password+"&scope="+normalClientScope+"&client_id="+normalClientId);
        Request request = new Request.Builder()
                .url(normalTokenUrl)
                .post(body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();

        Response response = client.newCall(request).execute();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(response.body().string(), AccessTokenResponse.class);
    }



}
