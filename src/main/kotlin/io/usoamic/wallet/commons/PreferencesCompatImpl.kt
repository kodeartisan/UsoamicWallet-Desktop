package io.usoamic.wallet.commons

import io.usoamic.wallet.commons.api.PreferencesCompat
import io.usoamic.wallet.commons.exceptions.PreferenceKeyNotFoundException
import java.util.prefs.Preferences
import javax.inject.Inject

class PreferencesCompatImpl @Inject constructor() : PreferencesCompat {
    private val preferences: Preferences get() = Preferences.userNodeForPackage(this::class.java)

    override fun getString(key: String): String {
        preferences.get(key, null)?.let {
            return it
        } ?: run {
            throw PreferenceKeyNotFoundException(key)
        }
    }

    override fun getLong(key: String): Long {
        val long = preferences.getLong(key, -1L)
        if (long == -1L) {
            throw PreferenceKeyNotFoundException(key)
        }
        return long
    }

    override fun putString(key: String, value: String) {
        preferences.put(key, value)
    }

    override fun putLong(key: String, value: Long) {
        preferences.putLong(key, value)
    }

    override fun remove(key: String) {
        preferences.remove(key)
    }

    override fun removeAll() {
        preferences.removeNode()
    }
}