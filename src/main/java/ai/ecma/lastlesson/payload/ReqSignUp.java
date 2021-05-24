package ai.ecma.lastlesson.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqSignUp {
    private UUID id;

    private String phoneNumber;

     private String password;

    private String fullName;
}
