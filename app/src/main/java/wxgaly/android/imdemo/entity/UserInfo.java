package wxgaly.android.imdemo.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by WXGALY on 2017/11/1.
 */

@Entity
public class UserInfo {

    @Id
    private long id;

    private String username;

    private String password;

    private int loginType;

}
