package br.com.murilorcm.watchprocessforkpoc.jna

import com.sun.jna.Library

interface CCountingNumbers : Library {
    fun count(args: String): Int
}