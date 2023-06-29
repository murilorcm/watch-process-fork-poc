package br.com.murilorcm.watchprocessforkpoc.services

import android.app.Service
import android.content.Intent
import android.os.IBinder

class CrashIOService : Service() {
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}