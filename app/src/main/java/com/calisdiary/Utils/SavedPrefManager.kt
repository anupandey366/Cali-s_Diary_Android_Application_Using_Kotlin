package com.calisdiary.Utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.preference.PreferenceManager

class SavedPrefManager(var context: Context) {



    companion object {
        //preferences variables
        const val Token = "Token"
        const val profileType = "profileType"
        const val userId = "userId"
        const val accessToken = "accessToken"
        const val channelId = "channelId"
        const val isSuggestion = "isSuggestion"
        const val isUser = "isUser"
        const val isVendor = "isVendor"
        const val DeviceToken = "DeviceToken"
        const val TRACKING_LAT = "trackingLat"
        const val TRACKING_LONG = "trackingLong"
        const val Language = "Language"
        const val isLanguage = "false"






        @SuppressLint("StaticFieldLeak")
        private var instance: SavedPrefManager? = null
        private const val PREF_HIGH_QUALITY = "pref_high_quality"


        fun getInstance(context: Context): SavedPrefManager? {
            if (instance == null) {
                synchronized(SavedPrefManager::class.java) {
                    if (instance == null) {
                        instance = SavedPrefManager(context)
                    }
                }
            }
            return instance
        }


        fun saveStringPreferences(context: Context?, key: String, value: String?): String {
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            val editor = sharedPreferences.edit()
            editor.putString(key, value)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                editor.apply()
            }
            return key
        }

        fun saveIntPreferences(context: Context?, key: String?, value: Int?) {
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            val editor = sharedPreferences.edit()
            if (value != null) {
                editor.putInt(key, value)
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                editor.apply()
            }
        }

        fun saveFloatPreferences(context: Context?, key: String?, value: Float) {
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            val editor = sharedPreferences.edit()
            editor.putFloat(key, value)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                editor.apply()
            }
        }

        /*
  This method is used to get string values from shared preferences.
   */
        fun getStringPreferences(context: Context?, key: String?): String? {
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            return sharedPreferences.getString(key, "")
        }

        /*
     This method is used to get string values from shared preferences.
      */
        fun getIntPreferences(context: Context?, key: String?): Int {
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            return sharedPreferences.getInt(key, 0)
        }

        fun savePreferenceBoolean(context: Context?, key: String?, b: Boolean) {
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            val editor = sharedPreferences.edit()
            editor.putBoolean(key, b)
            editor.apply()
        }

        /*
      This method is used to get string values from shared preferences.
       */
        fun getBooleanPreferences(context: Context?, key: String?): Boolean {
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            return sharedPreferences.getBoolean(key, false)
        }

        /**
         * Removes all the fields from SharedPrefs
         */
        fun clearPrefs(context: Context?) {
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
        }

        fun deleteAllKeys(context: Context?) {
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            val editor: SharedPreferences.Editor = sharedPreferences.edit()

            editor.remove("Token")
            editor.remove("MyRewardPoints")
            editor.remove("channelId")
            editor.remove("accessToken")
            editor.remove("userId")
            editor.remove("isSuggestion")
            editor.remove("profileType")
            editor.remove("isVendor")
            editor.remove("isUser")
            editor.remove("DeviceToken")

            editor.apply()
        }

        fun deleteChannelId(context: Context?) {
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            val editor: SharedPreferences.Editor = sharedPreferences.edit()


            editor.remove("channelId")
            editor.remove("accessToken")

            editor.apply()
        }



    }

}