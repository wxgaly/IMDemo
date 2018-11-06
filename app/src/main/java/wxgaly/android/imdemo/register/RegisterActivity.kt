package wxgaly.android.imdemo.register

import android.arch.lifecycle.Observer
import android.content.Intent
import android.databinding.DataBindingUtil
import wxgaly.android.imdemo.BaseActivity
import wxgaly.android.imdemo.R
import wxgaly.android.imdemo.databinding.ActivityRegisterBinding
import wxgaly.android.imdemo.util.obtainViewModel

/**
 * Created by WXGALY on 2017/11/20.
 */
class RegisterActivity : BaseActivity() {

    private lateinit var viewDataBinding: ActivityRegisterBinding

    override fun initData() {
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        viewDataBinding.registerViewModel = obtainViewModel(RegisterViewModel::class.java)

        val activity = this@RegisterActivity
        viewDataBinding.registerViewModel?.run {
            registerSuccessEvent.observe(activity, Observer {
                val userInfoIntent = Intent()
                userInfoIntent.putExtra("username", username.get())
                activity.setResult(REGISTER_SUCCESS_RESPONSE_CODE, userInfoIntent)
                finish()
            })
        }
    }


}