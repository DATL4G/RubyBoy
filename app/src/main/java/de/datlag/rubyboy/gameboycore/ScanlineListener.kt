package de.datlag.rubyboy.gameboycore

fun interface ScanlineListener {
    fun onScanline(colors: IntArray?, line: Int)
}