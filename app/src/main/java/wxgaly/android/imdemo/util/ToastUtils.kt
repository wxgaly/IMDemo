package wxgaly.android.imdemo.util

import android.content.Context
import android.widget.Toast

/**
 * Created by WXGALY on 2017/11/13.
 */
object ToastUtils {

    fun showToastShort(context: Context, message: String){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun showToastLong(context: Context, message: String){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}