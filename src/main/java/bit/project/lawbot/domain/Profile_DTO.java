package bit.project.lawbot.domain;

import lombok.Data;

@Data
public class Profile_DTO {
    private String nickname;
    private String thumbnail_image_url;
    private String profile_image_url;
    private boolean is_default_image;
}
