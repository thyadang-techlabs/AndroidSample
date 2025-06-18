package com.example.androidsample

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.techlabs.luckyverse.core.LuckyVerse

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        print("SOIDJO\n")

        LuckyVerse.instance().initialize(activity = this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnLuckyverse = findViewById<Button>(R.id.btnLuckyverse)
        btnLuckyverse.setOnClickListener {
            android.app.AlertDialog.Builder(this)
                .setTitle("서버 선택")
                .setMessage("어떤 서버를 실행하시겠습니까?")
                .setPositiveButton("개발 서버") { _, _ ->
                    setDevServer()
                    LuckyVerse.instance().openLuckyVerseMain(this)
                }
                .setNegativeButton("실 서버") { _, _ ->
                    setProdServer()
                    LuckyVerse.instance().openLuckyVerseMain(this)
                }
                .show()
        }

    }
    fun setDevServer() {
        var userId = ""
        val sharedPreferences = getSharedPreferences("app_prefs", MODE_PRIVATE)
        val savedUserId = sharedPreferences.getString("user_id_dev", null)

        if (savedUserId != null) {
            userId = savedUserId
        } else {
            val chars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
            val randomString = (1..5)
                .map { chars.random() }
                .joinToString("")

            userId = "thyadang.test.dev.${randomString}"

            sharedPreferences.edit().apply {
                putString("user_id_dev", userId)
                apply()
            }
        }



        LuckyVerse.instance().setGoToSettingCallback {
            print("✅ go to setting 콜백!\n")
            Toast.makeText(this, "go to setting 콜백 동작!", Toast.LENGTH_SHORT).show()
        }
        LuckyVerse.instance().updateUserId(userId)
        LuckyVerse.instance().updateAppKey("hana.kG7nP4vL9x.2025:lnTnv06")
        LuckyVerse.instance().updateADID("luckybite.hana.test001")
        LuckyVerse.instance().setRewardAdZoneId(activity = this, zoneId = "feed3072-a057-4e16-8a85-d4a6b0e57f92")
        LuckyVerse.instance().setInterstitialAdZoneId(activity = this, zoneId = "21abedc9-d901-43c0-b35d-40bfd8e12ea1")
    }

    fun setProdServer() {

        var userId = ""
        val sharedPreferences = getSharedPreferences("app_prefs", MODE_PRIVATE)
        val savedUserId = sharedPreferences.getString("user_id_prod", null)

        if (savedUserId != null) {
            userId = savedUserId
        } else {
            val chars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
            val randomString = (1..5)
                .map { chars.random() }
                .joinToString("")

            userId = "thyadang.test.prod.${randomString}"

            sharedPreferences.edit().apply {
                putString("user_id_prod", userId)
                apply()
            }
        }



        LuckyVerse.instance().setGoToSettingCallback {
            print("✅ go to setting 콜백!\n")
            Toast.makeText(this, "go to setting 콜백 동작!", Toast.LENGTH_SHORT).show()
        }
        LuckyVerse.instance().updateUserId(userId)
        LuckyVerse.instance().updateAppKey("hana.kG7nP4vL9x.2025")
        LuckyVerse.instance().updateADID("luckybite.hana.prod")
        LuckyVerse.instance().setRewardAdZoneId(activity = this, zoneId = "feed3072-a057-4e16-8a85-d4a6b0e57f92")
        LuckyVerse.instance().setInterstitialAdZoneId(activity = this, zoneId = "21abedc9-d901-43c0-b35d-40bfd8e12ea1")
    }
}