package io.oralit.usermanagementservice.adapter.inbound;

import io.oralit.usermanagementservice.response.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

/**
 * @author Minoltan Issack on 8/11/2022
 */
public abstract class AbstractController {
    HashMap<Integer, String> codeStatusMap = new HashMap();

    public AbstractController() {
        this.codeStatusMap.put(200, "OK");
        this.codeStatusMap.put(201, "Created");
        this.codeStatusMap.put(204, "No Content");
        this.codeStatusMap.put(400, "Bad Request");
        this.codeStatusMap.put(401, "Unauthorized");
        this.codeStatusMap.put(403, "Forbidden");
        this.codeStatusMap.put(404, "Not Found");
        this.codeStatusMap.put(500, "Server Error");
    }

    public ResponseEntity<Object> sendSuccessResponse(Object object) {
        return ResponseEntity.ok().body(new Response(object, (String)this.codeStatusMap.get(200)));
    }

}
