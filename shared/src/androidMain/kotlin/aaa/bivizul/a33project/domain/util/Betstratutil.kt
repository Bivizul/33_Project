@file:Suppress("DEPRECATION")

package aaa.bivizul.a33project.domain.util

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Uri
import android.telephony.TelephonyManager
import androidx.browser.customtabs.CustomTabsIntent
import com.onesignal.OneSignal
import kotlinx.coroutines.Dispatchers
import java.text.SimpleDateFormat
import java.util.*
import kotlin.coroutines.CoroutineContext

actual val betstratUiDispatcher: CoroutineContext = Dispatchers.Main

actual val betstratIoDispatcher: CoroutineContext = Dispatchers.IO

actual fun getBetstratmm(): String {
    val manfacbetstrat = android.os.Build.MANUFACTURER
    val modelbetstrat = android.os.Build.MODEL
    return "$manfacbetstrat $modelbetstrat"
}

actual fun getBetstratsim(betstratcon: Any): String {
    val context = betstratcon as Context
    val telmanbetstrat = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    return telmanbetstrat.simCountryIso
}

actual fun getBetstratid(betstratcon: Any): String {
    val context = betstratcon as Context
    val sharedPreferences = context.getSharedPreferences("appprefbetstrat", Context.MODE_PRIVATE)
    var betstratid = sharedPreferences.getString("betstrat_key", "nobetstrat") ?: "nobetstrat"
    if (betstratid == "nobetstrat") {
        val dateNow = Date()
        val simpleDateFormat = SimpleDateFormat("yyMMddhhmmssMs")
        val datetime = simpleDateFormat.format(dateNow)
        val randomNum = (10000 until 100000).random()
        betstratid = datetime + randomNum
        sharedPreferences.edit().putString("betstrat_key", betstratid).apply()
    }
    return betstratid
}

actual fun getBetstratl(): String {
    return Locale.getDefault().language
}

actual fun getBetstratt(): String {
    val betstrattz = TimeZone.getDefault().getDisplayName(false, TimeZone.SHORT)
    var betstratzone = "00:00"
    if (betstrattz.length > 3) {
        betstratzone = betstrattz.substring(3)
    }
    return betstratzone
}

actual fun getBetstratdlg(betstratcon: Any) {
    val context = betstratcon as Context
    val activity = betstratcon as Activity
    AlertDialog.Builder(context).apply {
        setTitle("Sorry, error connect complete")
        setMessage("Please try again later, push exit")
        setPositiveButton("Exit") { _, _ ->
            activity.finish()
            System.exit(0)
        }
        setCancelable(true)
    }.create().show()
}

@SuppressLint("MissingPermission")
actual fun checkBetstratnet(betstratcon: Any): Boolean {
    val context = betstratcon as Context
    val conmanbetstrat =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val netinfbetstrat = conmanbetstrat.activeNetworkInfo
    return netinfbetstrat != null && netinfbetstrat.isConnected
}

actual fun sigBetstratoff() {
    OneSignal.disablePush(true)
}

internal actual fun getBetstratactoff(betstratcon: Any) {
    val activity = betstratcon as Activity
    activity.finish()
    System.exit(0)
}

internal actual fun betstratct(betstratcon: Any, betstratcc: String) {
    val context = betstratcon as Context
    val activity = (context as? Activity)
    val betstratpn = "com.android.chrome"
    val betstratb = CustomTabsIntent.Builder()
        .setShowTitle(false)
        .setInstantAppsEnabled(true)
        .build()
    if (betstratpn != null) {
        betstratb.intent.setPackage(betstratpn)
        betstratb.launchUrl(context, Uri.parse(betstratcc))
    } else {
        val i = Intent(Intent.ACTION_VIEW, Uri.parse(betstratcc))
        activity?.startActivity(i)
    }
}