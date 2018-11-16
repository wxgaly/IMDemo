package wxgaly.android.imdemo.activity

import android.Manifest
import android.arch.lifecycle.Observer
import android.content.Intent
import android.databinding.DataBindingUtil
import permissions.dispatcher.NeedsPermission
import permissions.dispatcher.OnPermissionDenied
import permissions.dispatcher.RuntimePermissions
import wxgaly.android.imdemo.R
import wxgaly.android.imdemo.databinding.ActivityMainBinding
import wxgaly.android.imdemo.login.UserViewModel
import wxgaly.android.imdemo.register.RegisterActivity
import wxgaly.android.imdemo.util.Logger
import wxgaly.android.imdemo.util.ToastUtils
import wxgaly.android.imdemo.util.obtainViewModel
import wxgaly.android.imdemo.viewmodel.ViewModelType

@RuntimePermissions
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
        requireStorageWithPermissionCheck()
    }

    override fun obtainViewModel(): UserViewModel = obtainViewModel(UserViewModel::class.java, ViewModelType.USER_TYPE)

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

    @NeedsPermission(
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
            android.Manifest.permission.READ_EXTERNAL_STORAGE)
    fun requireStorage() {
        Logger.d(TAG, "申请权限")
    }

    @OnPermissionDenied(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE)
    fun onStorageDenied() {
        ToastUtils.showToastShort(this, getString(R.string.get_permission_fail))
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        onRequestPermissionsResult(requestCode, grantResults)
    }
}
