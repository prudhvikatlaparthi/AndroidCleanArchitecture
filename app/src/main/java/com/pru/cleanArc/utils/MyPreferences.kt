package com.pru.cleanArc.utils

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyPreferences @Inject constructor(
    @ApplicationContext context: Context
) {
    private val _prefs = context.getSharedPreferences("_preferences", Context.MODE_PRIVATE)

    fun getStringValue(keyName: String, defaultValue: String?): String? {
        return _prefs.getString(keyName, defaultValue)
    }


    fun setStringValue(keyName: String, value: String) {
        _prefs.edit().putString(keyName, value).apply()
    }

    private fun getIntegerValue(keyName: String, defaultValue: Int): Int {
        return _prefs.getInt(keyName, defaultValue)
    }

    private fun setIntegerValue(keyName: String, value: Int) {
        _prefs.edit().putInt(keyName, value).apply()
    }

    fun setBoolValue(keyName: String, value: Boolean) {
        _prefs.edit().putBoolean(keyName, value).apply()
    }

    fun getBoolValue(keyName: String, defaultValue: Boolean): Boolean {
        return _prefs.getBoolean(keyName, defaultValue)
    }

    private val loginUserID = "login-user-id"

    fun getLoginUserID(): Int = getIntegerValue(loginUserID, Int.MIN_VALUE)
    fun setLoginUserID(value: Int) {
        setIntegerValue(loginUserID, value)
    }
}