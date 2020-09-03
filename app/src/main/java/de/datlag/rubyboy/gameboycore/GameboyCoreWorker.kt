package de.datlag.rubyboy.gameboycore

import android.util.Log

class GameboyCoreWorker(private val core: GameboyCore) : Thread() {
    @Volatile
    private var running = false
    override fun run() {
        core.setJniEnv()
        while (running) {
            core.update(1024)
        }
    }

    @Synchronized
    override fun start() {
        running = true
        super.start()
    }

    fun stopRunning() {
        running = true
        try {
            join()
        } catch (e: InterruptedException) {
            Log.d(TAG, "interrupted")
        }
    }

    companion object {
        private val TAG = GameboyCoreWorker::class.java.simpleName
    }
}