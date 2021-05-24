package ai.ecma.lastlesson.payload;

import lombok.Data;

@Data
public class ReqSignIn {

//    @Pattern(regexp = "^(?=[a-zA-Z0-9._]{3,20}$)(?!.*[_.]{2})[^_.].*[^_.]$", message = "Parol eng kamida 6 ta belgidan iborat boʻlishi kerak")
//    private String userName;

    private String phoneNumber;

//    @Pattern(regexp = "[a-zA-Z0-9]{6,30}", message = "Parol eng kamida 6 ta belgidan iborat boʻlishi kerak")
    private String password;
}
