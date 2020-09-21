package tamanna.challange.interviews.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;
import java.util.Date;

@Data
public class ExceptionResponse {
    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;
    private String message;
    private String details;

    public ExceptionResponse(HttpStatus status, Date timestamp, String message, String details) {
        this.status = status;
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public ExceptionResponse(HttpStatus status, String message) {
        this.status = status;
        this.message=message;
    }

    public ExceptionResponse( String message) {
        this.message=message;
    }

}
