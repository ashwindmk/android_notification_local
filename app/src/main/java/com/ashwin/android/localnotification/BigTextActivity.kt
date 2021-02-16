package com.ashwin.android.localnotification

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_bigtext.*

class BigTextActivity : AppCompatActivity() {
    companion object {
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, BigTextActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bigtext)
    }

    fun notifyBigText(view: View) {
        val idInput = id_editText.text.toString()
        val id: Int = if (idInput.isBlank()) {
            -1
        } else {
            idInput.toInt()
        }

        val tagInput = tag_editText.text.toString()
        val tag = if (tagInput.equals("null")) {
            null
        } else {
            tagInput
        }

        val title = title_editText.text.toString()
        val text = text_editText.text.toString()
        val ticker = ticker_editText.text.toString()

        val bigTitle = bigtitle_editText.text.toString()
        val bigText = bigtext_editText.text.toString()
        val summary = summary_editText.text.toString()

        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val builder = NotificationCompat.Builder(this, Constant.CHANNEL_ID)
            .setContentTitle(title)
            .setContentText(text)
            .setTicker(ticker)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setStyle(NotificationCompat.BigTextStyle()
                .setBigContentTitle(bigTitle)
                .bigText(bigText)
                .setSummaryText(summary))

        builder.setContentIntent(
            PendingIntent.getActivity(applicationContext,
                Constant.BIGTEXT_ID,
                ReceiverActivity.getReceiverIntent(this).apply {
                    putExtra("key1", "val1")
                    putExtra("key2", 2)
                },
                PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_UPDATE_CURRENT
            )
        )

        builder.setAutoCancel(true)
        notificationManager.notify(tag, id, builder.build())
        Log.d(Constant.DEBUG_TAG, "BigTextActivity: notifyBigText: ($id, $tag): $title, $text")
    }
}
