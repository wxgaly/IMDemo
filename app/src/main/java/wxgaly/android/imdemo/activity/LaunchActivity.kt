package wxgaly.android.imdemo.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import wxgaly.android.imdemo.R
import wxgaly.android.imdemo.constant.IMConstant
import wxgaly.android.imdemo.entity.IUserInfo
import wxgaly.android.imdemo.entity.UserInfo
import wxgaly.android.imdemo.home.HomeActivity
import wxgaly.android.imdemo.login.UserViewModel
import wxgaly.android.imdemo.util.obtainViewModel
import wxgaly.android.imdemo.util.setFullScreen
import wxgaly.android.imdemo.viewmodel.ViewModelType

/**
 *  wxgaly.android.imdemo.
 *
 * @author Created by WXG on 2018/11/16 016 9:21.
 * @version V1.0
 */
class LaunchActivity : AppCompatActivity() {

    private val mHandler = Handler()
    private val mStartActivityRunnable = StartActivityRunnable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFullScreen()
        setContentView(R.layout.activity_lanuch)
        mHandler.postDelayed(mStartActivityRunnable, IMConstant.ActivityConstant.DURATION)
    }

    private inner class StartActivityRunnable : Runnable {

        override fun run() {
            startActivity()
        }
    }

    private fun startActivity() {
        val viewModel = obtainViewModel(UserViewModel::class.java, ViewModelType.USER_TYPE)
        viewModel.getUserInfos(object : IUserInfo.LoadUserInfoCallback {
            override fun onUserInfoLoaded(users: List<UserInfo>) {
                if (!users.isEmpty()) {
                    if (users[0].loginType == IMConstant.LoginType.LOGIN.ordinal) {
//                        startHomeActivity()
                        startMainActivity()
                    }
                }
            }

            override fun onDataNotAvailable() {
                startMainActivity()
            }

        })
    }

    private fun startHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }


}