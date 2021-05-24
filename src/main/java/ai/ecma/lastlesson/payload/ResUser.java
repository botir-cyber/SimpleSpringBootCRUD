/* Created by IntelliJ IDEA.
 User: Mirzaahmatov Aziz
Date: 5/22/2021
Time: 8:54 PM
 To change this template use File | Settings | File Templates.
*/
package ai.ecma.lastlesson.payload;

import ai.ecma.lastlesson.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResUser {
    private UUID id;
    private String fullName;
    private String phoneNumber;

    public ResUser(User user) {
        this.id = user.getId();
        this.fullName = user.getFullName();
        this.phoneNumber = user.getPhoneNumber();
    }
}
