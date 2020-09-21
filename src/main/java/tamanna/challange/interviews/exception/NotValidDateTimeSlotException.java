package tamanna.challange.interviews.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotValidDateTimeSlotException extends RuntimeException{
    public NotValidDateTimeSlotException(String message){
        super(message);
    }
}
