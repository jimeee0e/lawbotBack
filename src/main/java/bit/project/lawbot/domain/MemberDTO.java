package bit.project.lawbot.domain;

import lombok.Data;

@Data
public class MemberDTO {
    private long pk_member_no;
    private String email;
    private String name;
    private String pass;
    private String role;
    private String platform;
    private int isLive;
}
