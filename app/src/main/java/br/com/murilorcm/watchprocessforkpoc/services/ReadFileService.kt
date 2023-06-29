package br.com.murilorcm.watchprocessforkpoc.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast
import br.com.murilorcm.watchprocessforkpoc.jna.CCountingNumbers
import br.com.murilorcm.watchprocessforkpoc.jna.CReadingNumbers
import com.sun.jna.Native
import java.io.File

class ReadFileService : Service() {

    override fun onCreate() {
        println("+++ReadFileService.OnCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        println("+++ReadFileService.OnStartCommand")
        Toast.makeText(
            this,
            "Iniciando a leitura do arquivo",
            Toast.LENGTH_SHORT
        ).show()

        try {
            val dir = this.getExternalFilesDir(null)

            check(dir != null)

            System.loadLibrary("readingnumbers")

            val numbers = Native.load("readingnumbers", CReadingNumbers::class.java)

            val result = numbers.read(File(dir, "numbers.txt").absolutePath)

            assert(result == 0) {"Execution: $result"}

        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(
                this,
                "Erro: $e",
                Toast.LENGTH_SHORT
            ).show()
        } finally {
            stopSelf()
        }

        return START_NOT_STICKY
    }

    override fun onDestroy() {
        Toast.makeText(
            this,
            "Finalizada a leitura do arquivo.",
            Toast.LENGTH_SHORT
        ).show()

        super.onDestroy()
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}