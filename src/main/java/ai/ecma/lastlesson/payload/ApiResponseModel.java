package ai.ecma.lastlesson.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseModel {
    private boolean success;
    private String message;
    private Object object;

    public ApiResponseModel(boolean success, Object object) {
        this.success = success;
        this.object = object;
    }

    public ApiResponseModel(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
