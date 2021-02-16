package com.ashwin.android.localnotification

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_receiver.*

class ReceiverActivity : AppCompatActivity() {
    companion object {
        fun getReceiverIntent(context: Context): Intent {
            return Intent(context, ReceiverActivity::class.java)
        }

        fun startActivity(context: Context) {
            context.startActivity(getReceiverIntent(context))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receiver)
        val b = intent?.extras?.toMap()
        Log.d(Constant.DEBUG_TAG, "ReceiverActivity: onCreate: $intent\n\t$b")
        setIntentContent(intent)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d(Constant.DEBUG_TAG, "ReceiverActivity: onNewIntent: $intent\n\t${intent?.extras?.toMap()}")
        setIntentContent(intent)
    }

    private fun setIntentContent(intent: Intent?) {
        if (intent != null) {
            intent_textview.text = "$intent\n\t${intent?.extras?.toMap()}"
        } else {
            intent_textview.text = "null"
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d(Constant.DEBUG_TAG, "ReceiverActivity: onResume")
    }
}
