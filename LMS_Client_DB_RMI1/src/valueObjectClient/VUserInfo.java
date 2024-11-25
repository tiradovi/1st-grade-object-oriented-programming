package valueObjectClient;

import java.io.Serializable;

public class VUserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;
    private String password;
    private String name;

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
