package wxgaly.android.imdemo

import android.arch.lifecycle.Observer
import android.content.Intent
import android.databinding.DataBindingUtil
import wxgaly.android.imdemo.databinding.ActivityMainBinding
import wxgaly.android.imdemo.login.UserViewModel
import wxgaly.android.imdemo.register.RegisterActivity
import wxgaly.android.imdemo.util.Logger
import wxgaly.android.imdemo.util.obtainViewModel

class MainActivity : BaseActivity() {

    val TAG = "MainActivity"
    lateinit var username: String
    lateinit var password: String
    private lateinit var viewDataBinding: ActivityMainBinding

    override fun initData() {
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewDataBinding.userViewModel = obtainViewModel()
        viewDataBinding.userViewModel!!.getUserInfos(null)

        val activity = this@MainActivity
        viewDataBinding.userViewModel?.run {
            registerSingleLiveEvent.observe(activity, Observer {
                val intent = Intent().apply {
                    setClass(activity, RegisterActivity::class.java)
                }
                activity.startActivityForResult(intent, REGISTER_SUCCESS_REQUEST_CODE)
            })

        }
    }

    fun obtainViewModel(): UserViewModel = obtainViewModel(UserViewModel::class.java)

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REGISTER_SUCCESS_REQUEST_CODE && resultCode == REGISTER_SUCCESS_RESULT_CODE) {
            data?.apply {
                viewDataBinding.userViewModel?.apply {
                    Logger.d(TAG, "$KEY_USERNAME : ${getStringExtra(KEY_USERNAME)}")
                    username.set(getStringExtra(KEY_USERNAME))
                    password.set(getStringExtra(KEY_PASSWORD))
                }
            }
        }
    }
}
