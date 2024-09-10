package spring_learn.demo.exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    USER_EXISTED(1001,"User existed", HttpStatus.BAD_REQUEST),
    UNCATAEGORIZED_EXCEPTION(9999,"Uncategorized exception",HttpStatus.INTERNAL_SERVER_ERROR),
    USERNAME_NOT_LONG_ENOUGH(1002,"Must be at least 5 character", HttpStatus.BAD_REQUEST),
    PASSWORD_NOT_LONG_ENOUGH(1003,"Must be at least 8 character", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(1004,"User existed", HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(8888,"Unauthenticated", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(7777,"You do not have permission",HttpStatus.FORBIDDEN),
    ;

    private int code;
    private String message;
    private HttpStatusCode statusCode;

    ErrorCode(int code, String message,HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }


}
