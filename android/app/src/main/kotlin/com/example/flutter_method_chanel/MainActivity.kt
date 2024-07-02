package com.example.flutter_method_chanel

import android.content.Context
import android.media.RingtoneManager
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity : FlutterActivity() {
    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)

        val channel = "flutter_channel"

        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, channel)
            .setMethodCallHandler { call, result ->
                when (call.method) {
                    "getAll" -> {
                        result.success(getAllRingtones(this));
                    }
                }
            }
    }

    private fun getAllRingtones(context: Context): List<String> {
        val manager = RingtoneManager(context);
        manager.setType(RingtoneManager.TYPE_RINGTONE)

        val cursor = manager.cursor
        val list = mutableListOf<String>()

        while (cursor.moveToNext()) {
            val title = cursor.getString(RingtoneManager.TITLE_COLUMN_INDEX)
            list.add(title)
        }

        return list;
    }
}
