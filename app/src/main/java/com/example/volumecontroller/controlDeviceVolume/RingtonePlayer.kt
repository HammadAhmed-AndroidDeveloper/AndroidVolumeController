package com.example.volumecontroller.controlDeviceVolume

import android.content.Context
import android.media.MediaPlayer
import android.media.RingtoneManager

class RingtonePlayer {
    private var alarmMediaPlayer: MediaPlayer? = null
    private var mediaPlayer: MediaPlayer? = null
    private var notificationMediaPlayer: MediaPlayer? = null
    private var systemMediaPlayer: MediaPlayer? = null

    fun playAlarmTone(context: Context?) {
        if (alarmMediaPlayer == null) {
            alarmMediaPlayer = MediaPlayer.create(
                context,
                RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
            )
        }
        alarmMediaPlayer!!.isLooping = true
        alarmMediaPlayer!!.start()
    }

    fun stopAlarmTone() {
        alarmMediaPlayer!!.stop()
    }

    fun playMediaTone(context: Context?) {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(
                context,
                RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE)
            )
        }
        mediaPlayer!!.isLooping = true
        mediaPlayer!!.start()
    }

    fun stopMediaTone() {
        mediaPlayer!!.stop()
    }

    fun playNotificationTone(context: Context?) {
        if (notificationMediaPlayer == null) {
            notificationMediaPlayer = MediaPlayer.create(
                context,
                RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            )
        }
        notificationMediaPlayer!!.isLooping = true
        notificationMediaPlayer!!.start()
    }

    fun stopNotificationTone() {
        notificationMediaPlayer!!.stop()
    }

    fun playSystemTone(context: Context?) {
        if (systemMediaPlayer == null) {
            systemMediaPlayer =
                MediaPlayer.create(context, RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALL))
        }
        systemMediaPlayer!!.isLooping = true
        systemMediaPlayer!!.start()
    }

    fun stopSystemTone() {
        systemMediaPlayer!!.stop()
    }
}