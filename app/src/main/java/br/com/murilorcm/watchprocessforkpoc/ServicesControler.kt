package br.com.murilorcm.watchprocessforkpoc

import android.content.Context
import android.content.Intent
import android.widget.Toast
import br.com.murilorcm.watchprocessforkpoc.services.CrashIOService
import br.com.murilorcm.watchprocessforkpoc.services.CreateFileService
import br.com.murilorcm.watchprocessforkpoc.services.ReadFileService
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class ServicesControler(private val context: Context) {

    private val dir = context.getExternalFilesDir(null)
    private val numbersFile = File(dir, "numbers.txt")

    fun startAllServices() {

        createSampleFile()

        context.startService(Intent(context, CreateFileService::class.java))
        context.startService(Intent(context, ReadFileService::class.java))
        context.startService(Intent(context, CrashIOService::class.java))
    }

    fun stopAllServices() {
        context.stopService(Intent(context, CreateFileService::class.java))
        context.stopService(Intent(context, ReadFileService::class.java))
        context.stopService(Intent(context, CrashIOService::class.java))
    }

    private fun createSampleFile() {
        if (!numbersFile.exists()) {
            try {
                FileOutputStream(numbersFile).use {
                    for (i in 0..10000) {
                        it.write("$i\n".toByteArray())
                    }
                }

                Toast.makeText(context, "The file has been successfully created and populated.", Toast.LENGTH_SHORT)
                    .show()
            } catch (e: IOException) {
                e.printStackTrace()
                Toast.makeText(context, "An error occurred while creating the file: ${e.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}