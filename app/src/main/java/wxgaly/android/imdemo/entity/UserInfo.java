package wxgaly.android.imdemo.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by WXGALY on 2017/11/1.
 */

@Entity
public class UserInfo {

    @Id
    private long id;

    @Property(nameInDb = "username")
    private String username;

    @Property(nameInDb = "password")
    private String password;

    @Property(nameInDb = "loginType")
    private int loginType;

    @Generated(hash = 2125976427)
    public UserInfo(long id, String username, String password, int loginType) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.loginType = loginType;
    }

    @Generated(hash = 1279772520)
    public UserInfo() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLoginType() {
        return this.loginType;
    }

    public void setLoginType(int loginType) {
        this.loginType = loginType;
    }

}
