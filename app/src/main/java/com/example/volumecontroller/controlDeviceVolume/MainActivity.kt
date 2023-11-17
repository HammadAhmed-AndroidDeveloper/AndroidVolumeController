package com.example.volumecontroller.controlDeviceVolume

import android.media.AudioManager
import android.os.Bundle
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatSeekBar

class MainActivity : AppCompatActivity() {

    private var alarmSeekBar: AppCompatSeekBar? = null
    private var mediaSeekBar: AppCompatSeekBar? = null
    private var voiceCallSeekBar: AppCompatSeekBar? = null
    private var ringSeekBar: AppCompatSeekBar? = null
    private var notificationsSeekBar: AppCompatSeekBar? = null
    private var systemSoundsSeekBar: AppCompatSeekBar? = null
    private var dtmfSeekbar: AppCompatSeekBar? = null
    private var accessibilitySeekbar: AppCompatSeekBar? = null
    private var audioManager: AudioManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        alarmSeekBar = findViewById(R.id.alarmSeekBar)
        mediaSeekBar = findViewById(R.id.mediaSeekBar)
        voiceCallSeekBar = findViewById(R.id.voiceCallSeekBar)
        ringSeekBar = findViewById(R.id.ringSeekBar)
        notificationsSeekBar = findViewById(R.id.notificationsSeekBar)
        systemSoundsSeekBar = findViewById(R.id.systemSoundsSeekBar)
        dtmfSeekbar = findViewById(R.id.dtmfSeekbar)
        accessibilitySeekbar = findViewById(R.id.accessibilitySeekbar)

        audioManager = getSystemService(AUDIO_SERVICE) as AudioManager
        alarmSeekBar?.max = audioManager!!.getStreamMaxVolume(AudioManager.STREAM_ALARM)
        alarmSeekBar?.progress = audioManager!!.getStreamVolume(AudioManager.STREAM_ALARM)
        mediaSeekBar?.max = audioManager!!.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
        mediaSeekBar?.progress = audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC)
        voiceCallSeekBar?.max = audioManager!!.getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL)
        voiceCallSeekBar?.progress = audioManager!!.getStreamVolume(AudioManager.STREAM_VOICE_CALL)
        ringSeekBar?.max = audioManager!!.getStreamMaxVolume(AudioManager.STREAM_RING)
        ringSeekBar?.progress = audioManager!!.getStreamVolume(AudioManager.STREAM_RING)

        notificationsSeekBar?.max =
            audioManager!!.getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION)
        notificationsSeekBar?.progress =
            audioManager!!.getStreamVolume(AudioManager.STREAM_NOTIFICATION)
        systemSoundsSeekBar?.max = audioManager!!.getStreamMaxVolume(AudioManager.STREAM_SYSTEM)
        systemSoundsSeekBar?.progress = audioManager!!.getStreamVolume(AudioManager.STREAM_SYSTEM)
        dtmfSeekbar?.max = audioManager!!.getStreamMaxVolume(AudioManager.STREAM_DTMF)
        dtmfSeekbar?.progress = audioManager!!.getStreamVolume(AudioManager.STREAM_DTMF)
        accessibilitySeekbar?.max =
            audioManager!!.getStreamMaxVolume(AudioManager.STREAM_ACCESSIBILITY)
        accessibilitySeekbar?.progress =
            audioManager!!.getStreamVolume(AudioManager.STREAM_ACCESSIBILITY)

        val rp = RingtonePlayer()
        alarmSeekBar?.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                if (b) {
                    audioManager!!.setStreamVolume(AudioManager.STREAM_ALARM, i, 0)
                    rp.playAlarmTone(this@MainActivity)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                rp.stopAlarmTone()
            }
        })
        mediaSeekBar?.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                if (b) {
                    audioManager!!.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0)
                    rp.playMediaTone(this@MainActivity)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                rp.stopMediaTone()
            }
        })
        voiceCallSeekBar?.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                if (b) {
                    audioManager!!.setStreamVolume(AudioManager.STREAM_VOICE_CALL, i, 0)
                    rp.playMediaTone(this@MainActivity)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                rp.stopMediaTone()
            }
        })
        ringSeekBar?.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                if (b) {
                    audioManager!!.setStreamVolume(AudioManager.STREAM_RING, i, 0)
                    rp.playMediaTone(this@MainActivity)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                rp.stopMediaTone()
            }
        })
        notificationsSeekBar?.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                if (b) {
                    audioManager!!.setStreamVolume(AudioManager.STREAM_NOTIFICATION, i, 0)
                    rp.playNotificationTone(this@MainActivity)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                rp.stopNotificationTone()
            }
        })
        systemSoundsSeekBar?.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                if (b) {
                    audioManager!!.setStreamVolume(AudioManager.STREAM_SYSTEM, i, 0)
                    rp.playSystemTone(this@MainActivity)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                rp.stopSystemTone()
            }
        })
        dtmfSeekbar?.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                if (b) {
                    audioManager!!.setStreamVolume(AudioManager.STREAM_DTMF, i, 0)
                    rp.playSystemTone(this@MainActivity)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                rp.stopSystemTone()
            }
        })
        accessibilitySeekbar?.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                if (b) {
                    audioManager!!.setStreamVolume(AudioManager.STREAM_ACCESSIBILITY, i, 0)
                    rp.playSystemTone(this@MainActivity)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                rp.stopSystemTone()
            }
        })
    }
}