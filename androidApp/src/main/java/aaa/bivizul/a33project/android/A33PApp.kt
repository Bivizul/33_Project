package aaa.bivizul.a33project.android

import aaa.bivizul.a33project.domain.util.Betstratcon.BETSTRATOSAI
import android.app.Application
import com.onesignal.OneSignal

class A33PApp : Application() {

    override fun onCreate() {
        super.onCreate()

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(BETSTRATOSAI)

    }

}