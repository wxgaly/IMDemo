package wxgaly.android.imdemo

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.widget.Toast
import cn.jpush.im.android.api.JMessageClient
import cn.jpush.im.api.BasicCallback
import com.dd.processbutton.iml.ActionProcessButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var username: String
    lateinit var password: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        JMessageClient.setDebugMode(true)
        JMessageClient.init(this)

        initListener()
    }

    private fun initListener() {

        btn_register.setOnClickListener { view ->
            if (!TextUtils.isEmpty(et_username.text) && !TextUtils.isEmpty(et_password.text)) {
                username = et_username.text.toString().trim()
                password = et_password.text.toString().trim()
                Toast.makeText(this, "username is $username and password is $password",
                        Toast.LENGTH_SHORT).show()
                registerIM()
            } else {
                Toast.makeText(this, getString(R.string.username_or_password_is_not_null),
                        Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun registerIM() {
        btn_register.progress = 1
        JMessageClient.register(username, password, JMessageRegisterCallback(btn_register, this))
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

}
