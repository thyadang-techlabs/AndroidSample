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


        LuckyVerse.instance().updateUserId("사용자 식별자")
        LuckyVerse.instance().updateAppKey("테크랩스로부터 전달받은 앱 키")
        LuckyVerse.instance().updateADID("쿠팡 추적 광고에 사용할 adid")
        LuckyVerse.instance().setRewardAdZoneIdForSaju("사주가 필요한 컨텐츠를 볼 때 쓸 리워드 광고 존 아이디")
        LuckyVerse.instance().setRewardAdZoneIdForNotSaju("사주가 필요 없는 컨텐츠를 볼 때 쓸 리워드 광고 존 아이디")
        LuckyVerse.instance().setRewardAdZoneIdForFortuneCookie("포춘쿠키 컨텐츠를 볼 때 쓸 리워드 광고 존 아이디")

        LuckyVerse.instance().setGoToSettingCallback {
            print("✅ go to setting 콜백!\n")
            Toast.makeText(this, "go to setting 콜백 동작!", Toast.LENGTH_SHORT).show()
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnLuckyverse = findViewById<Button>(R.id.btnLuckyverse)
        btnLuckyverse.setOnClickListener {
            LuckyVerse.instance().openLuckyVerseMain(this)
        }

    }
}