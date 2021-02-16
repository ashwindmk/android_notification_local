package com.ashwin.android.localnotification

import android.os.Bundle

fun Bundle.toMap(): Map<String, Any?> {
    val map: MutableMap<String, Any?> = HashMap()
    val ks = this.keySet()
    val iterator: Iterator<String> = ks.iterator()
    while (iterator.hasNext()) {
        val key = iterator.next()
        map[key] = this.get(key)
    }
    return map.toMap()
}
