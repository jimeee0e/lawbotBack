package bit.project.lawbot.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Getter
@NoArgsConstructor
public class AuthDTO {
    private String code;
    private String redirect_uri = "http://localhost:3000/register";
    private String grant_type = "authorization_code";
    private String client_id = "26c6196da16420765dc0c6251030d217";

    private String access_token;
    private int expires_in;
    private String id_token;
    private String refresh_token;
    private int refresh_token_expires_in;
    private String scope;
    private String token_type;

    private long id;

    private Kakao_account_DTO kakao_account;
}