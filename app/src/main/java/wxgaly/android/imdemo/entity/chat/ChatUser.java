package wxgaly.android.imdemo.entity.chat;

import cn.jiguang.imui.commons.models.IUser;

/**
 * wxgaly.android.imdemo.entity.chat.
 *
 * @author Created by WXG on 2018/11/11 13:50.
 * @version V1.0
 */
public class ChatUser implements IUser {

    private String id;
    private String displayName;
    private String avatar;

    public ChatUser(String id, String displayName, String avatar) {
        this.id = id;
        this.displayName = displayName;
        this.avatar = avatar;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String getAvatarFilePath() {
        return avatar;
    }
}
