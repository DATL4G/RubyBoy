package de.datlag.rubyboy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import de.datlag.rubyboy.gameboycore.GameboyCore
import de.datlag.rubyboy.gameboycore.GameboyCoreWorker
import de.datlag.rubyboy.gameboycore.ScanlineListener

class MainActivity : AppCompatActivity() {

    companion object {
        init {
            System.loadLibrary("gameboycore-jni")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val core = GameboyCore()
        val coreUpdater = GameboyCoreWorker(core)
    }
}