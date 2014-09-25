package tw.edu.ncu.cc.manage.openid;

public class OpenIDException extends Exception {

    private static final long serialVersionUID = 1L;
    private final String error;

    public OpenIDException(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "openid exception: " + error;
    }
}
