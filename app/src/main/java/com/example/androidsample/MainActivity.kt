package com.example.androidsample

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.techlabs.luckyverse.core.LuckyVerse

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        LuckyVerse.instance().updateUserId("luckybite.hana.test001")
        LuckyVerse.instance().updateAppKey("luckybite.hana.test001")
        val btnLuckyverse = findViewById<Button>(R.id.btnLuckyverse)
        btnLuckyverse.setOnClickListener {
            runLuckyverse()
        }
        LuckyVerse.instance().setGoToSettingCallback {
            Toast.makeText(this, "설정 이동 콜백 동작!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun runLuckyverse() {
        LuckyVerse.instance().openLuckyVerseMain(this)
//        LuckyVerse.instance().openLuckyVerseSajuInfo(this)
    }
}