package com.ashwin.android.localnotification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannel()
        }
    }

    fun openBigText(view: View) {
        BigTextActivity.startActivity(this)
    }

    fun openReceiver(view: View) {
        ReceiverActivity.startActivity(this)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createChannel() {
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channel = NotificationChannel(Constant.CHANNEL_ID, Constant.CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH)
        channel.description = Constant.CHANNEL_DESCRIPTION
        notificationManager.createNotificationChannel(channel)
    }
}