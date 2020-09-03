package de.datlag.rubyboy.gameboycore

class GameboyCore {
    private val handle: Long
    fun release() {
        release(handle)
    }

    fun update(steps: Int) {
        update(handle, if (steps < 0) 0 else steps)
    }

    fun loadRom(buffer: ByteArray) {
        loadRomFromBuffer(handle, buffer)
    }

    fun registerScanlineCallback(listener: ScanlineListener) {
        registerScanlineCallback(handle, listener)
    }

    fun setJniEnv() {
        setJniEnv(handle)
    }

    /* Native Functions */
    private external fun createInstance(): Long
    private external fun release(handle: Long)
    private external fun update(handle: Long, steps: Int)
    private external fun loadRomFromBuffer(handle: Long, buffer: ByteArray)
    private external fun registerScanlineCallback(handle: Long, listener: ScanlineListener)
    private external fun setJniEnv(handle: Long)

    init {
        handle = createInstance()
    }
}