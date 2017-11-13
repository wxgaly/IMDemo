package wxgaly.android.imdemo

import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.support.v7.app.AppCompatActivity

/**
 *  wxgaly.android.imdemo.
 * Temporary class until Architecture Components is final. Makes [AppCompatActivity] a
 * [LifecycleRegistryOwner].
 * @author Created by WXG on 2017/11/9 009 10:01.
 * @version V1.0
 */
open class LifecycleAppCompatActivity : AppCompatActivity(), LifecycleRegistryOwner {

    private val registry = LifecycleRegistry(this)

    override fun getLifecycle(): LifecycleRegistry = registry
}
