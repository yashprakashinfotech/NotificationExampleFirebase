package com.example.notificationexamplefirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.ktx.messaging
import com.google.firebase.messaging.ktx.remoteMessage
import java.util.concurrent.atomic.AtomicInteger

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w("Boss", "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }
            else {
                // Get new FCM registration token
                val token = task.result

                // Log and toast
                Log.d("Boss", "Token:"+token)
                Toast.makeText(baseContext, "Token Generation", Toast.LENGTH_SHORT).show()
            }

        })
    }

//    companion object {
//        private const val TAG = "MainActivity"
//    }
//
//    fun runtimeEnableAutoInit() {
//        // [START fcm_runtime_enable_auto_init]
//        Firebase.messaging.isAutoInitEnabled = true
//        // [END fcm_runtime_enable_auto_init]
//    }
//
//    fun deviceGroupUpstream() {
//        // [START fcm_device_group_upstream]
//        val to = "a_unique_key" // the notification key
//        val msgId = AtomicInteger()
//        Firebase.messaging.send(remoteMessage(to) {
//            setMessageId(msgId.get().toString())
//            addData("hello", "world")
//        })
//        // [END fcm_device_group_upstream]
//    }
//
//    fun sendUpstream() {
//        val SENDER_ID = "YOUR_SENDER_ID"
//        val messageId = 0 // Increment for each
//        // [START fcm_send_upstream]
//        val fm = Firebase.messaging
//        fm.send(remoteMessage("$SENDER_ID@fcm.googleapis.com") {
//            setMessageId(messageId.toString())
//            addData("my_message", "Hello World")
//            addData("my_action", "SAY_HELLO")
//        })
//        // [END fcm_send_upstream]
//    }
}