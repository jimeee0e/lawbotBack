package bit.project.lawbot.domain;

import lombok.Data;

@Data
public class Kakao_account_DTO {
    private boolean profile_nickname_needs_agreement;
    private boolean profile_image_needs_agreement;
    private boolean has_email;
    private boolean email_needs_agreement;
    private boolean is_email_valid;
    private boolean is_email_verified;
    private String email;

    private Profile_DTO profile;
}
