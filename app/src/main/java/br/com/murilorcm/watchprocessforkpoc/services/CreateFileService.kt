package br.com.murilorcm.watchprocessforkpoc.services

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.widget.Toast
import br.com.murilorcm.watchprocessforkpoc.jna.CCountingNumbers
import com.sun.jna.Native
import java.io.File
import java.lang.Thread.sleep

class CreateFileService : Service() {

    override fun onCreate() {
        println("+++CreateFileService.OnCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(
            this,
            "Iniciando a criação do arquivo",
            Toast.LENGTH_SHORT
        ).show()

        try {
            val dir = this.getExternalFilesDir(null)

            check(dir != null)

            System.loadLibrary("countingnumbers")

            val numbers = Native.load("countingnumbers", CCountingNumbers::class.java)

            val result = numbers.count(File(dir, "numbersbyc.txt").absolutePath)

            assert(result == 0) { "Execution: $result" }

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
            "Finalizada a criação do arquivo.",
            Toast.LENGTH_SHORT
        ).show()

        super.onDestroy()
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}