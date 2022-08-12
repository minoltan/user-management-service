package io.oralit.usermanagementservice.response;

public class AccessTokenResponse {
    private String access_token;
    private String refresh_token;
    private String scope;
    private String session_state;
    private String expires_in;
    private String refresh_expires_in;

    public AccessTokenResponse() {
    }

    public AccessTokenResponse(String access_token, String refresh_token, String scope, String session_state, String expires_in, String refresh_expires_in) {
        this.access_token = access_token;
        this.refresh_token = refresh_token;
        this.scope = scope;
        this.session_state = session_state;
        this.expires_in = expires_in;
        this.refresh_expires_in = refresh_expires_in;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getSession_state() {
        return session_state;
    }

    public void setSession_state(String session_state) {
        this.session_state = session_state;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public String getRefresh_expires_in() {
        return refresh_expires_in;
    }

    public void setRefresh_expires_in(String refresh_expires_in) {
        this.refresh_expires_in = refresh_expires_in;
    }

    @Override
    public String toString() {
        return "AccessTokenResponse{" +
                "access_token='" + access_token + '\'' +
                ", refresh_token='" + refresh_token + '\'' +
                ", scope='" + scope + '\'' +
                ", session_state='" + session_state + '\'' +
                ", expires_in='" + expires_in + '\'' +
                ", refresh_expires_in='" + refresh_expires_in + '\'' +
                '}';
    }
}
