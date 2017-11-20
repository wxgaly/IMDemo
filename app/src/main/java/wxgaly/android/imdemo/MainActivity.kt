package wxgaly.android.imdemo

import android.content.Context
import android.databinding.DataBindingUtil
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import cn.jpush.im.android.api.JMessageClient
import cn.jpush.im.android.api.callback.GetUserInfoCallback
import cn.jpush.im.android.api.model.UserInfo
import cn.jpush.im.api.BasicCallback
import com.dd.processbutton.iml.ActionProcessButton
import kotlinx.android.synthetic.main.activity_main.*
import wxgaly.android.imdemo.databinding.ActivityMainBinding
import wxgaly.android.imdemo.login.UserViewModel
import wxgaly.android.imdemo.util.obtainViewModel

class MainActivity : AppCompatActivity() {


    lateinit var username: String
    lateinit var password: String
    private lateinit var viewDataBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        setContentView(R.layout.activity_main)

        setFullScreen()
        initData()
        initListener()

    }

    private fun setFullScreen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                val option: Int = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                window.decorView.systemUiVisibility = option
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = Color.TRANSPARENT
            } else {

                val param: WindowManager.LayoutParams = window.attributes
                var flagTranslucentStatus: Int = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                param.flags = param.flags or flagTranslucentStatus
                window.attributes = param

            }
        }

    }

    private fun initData() {
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewDataBinding.userViewModel = obtainViewModel()
    }

    private fun initListener() {

//        btn_register.setOnClickListener {
//            if (!TextUtils.isEmpty(et_username.text) && !TextUtils.isEmpty(et_password.text)) {
//                username = et_username.text.toString().trim()
//                password = et_password.text.toString().trim()
//                Toast.makeText(this, "username is $username and password is $password",
//                        Toast.LENGTH_SHORT).show()
//                registerIM()
//            } else {
//                Toast.makeText(this, getString(R.string.username_or_password_is_not_null),
//                        Toast.LENGTH_SHORT).show()
//            }
//        }

        btn_logout.setOnClickListener {
            logout()
        }
    }

    private fun logout() {
        btn_logout.progress = 1
        JMessageClient.logout()
        btn_logout.progress = 100
    }

    private fun registerIM() {
        btn_register.progress = 1
//        JMessageClient.register(username, password, JMessageRegisterCallback(btn_register, this))
        JMessageClient.login(username, password, JMessageRegisterCallback(btn_register, this))
        JMessageClient.getUserInfo(username, JMessageLoginCallback(this))
    }

    open class JMessageLoginCallback(private val context: Context) : GetUserInfoCallback() {
        override fun gotResult(code: Int, message: String?, userInfo: UserInfo?) {

            Toast.makeText(context, "code is $code and message is $message, userInfo is " +
                    "${userInfo?.displayName}",
                    Toast.LENGTH_SHORT).show()
        }

    }

    open class JMessageRegisterCallback(private val button: ActionProcessButton?, private val
    context: Context) : BasicCallback() {

        override fun gotResult(code: Int, message: String?) {

            Toast.makeText(context, "code is $code and message is $message",
                    Toast.LENGTH_SHORT).show()

            if (code == 0) {
                button?.progress = 100
            } else {
                button?.progress = -1
            }

        }
    }

    fun obtainViewModel(): UserViewModel = obtainViewModel(UserViewModel::class.java)

}
