package br.com.murilorcm.watchprocessforkpoc.jna

import com.sun.jna.Library

interface CReadingNumbers : Library {
    fun read(args: String): Int
}