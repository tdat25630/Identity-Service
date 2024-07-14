package spring_learn.demo.exception;

public enum ErrorCode {
    USER_EXISTED(1001,"User existed"),
    UNCATAEGORIZED_EXCEPTION(9999,"Uncategorized exception"),
    USERNAME_NOT_LONG_ENOUGH(1002,"Must be at least 5 character"),
    PASSWORD_NOT_LONG_ENOUGH(1003,"Must be at least 8 character"),
    USER_NOT_EXISTED(1004,"User existed"),
    UNAUTHENTICATED(8888,"Unauthenticated"),
    ;

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
