package com.thanht.hometest.utils

import android.graphics.Color
import kotlin.random.Random

fun randomColor(): Int {
    val rand = Random
    return Color.rgb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255))
}

fun formatLine(keyword: String): String {
    return wrapWordsByCharacter(keyword, 2)
}

fun wrapWordsByWord(keyword: String): String {
    val arrKeyword = keyword.trim { it <= ' ' }.split(" ")
    val builder: StringBuilder = java.lang.StringBuilder()
    if (arrKeyword.size > 1) {
        var first = ""
        var rest = ""
        val midPos = arrKeyword.size / 2

        for (pos in 0 until midPos) {
            first += arrKeyword[pos] + " "
        }
        for (pos in midPos until arrKeyword.size) {
            rest += arrKeyword[pos] + " "
        }
        builder.append(first.trim())
        builder.append("\n")
        builder.append(rest.trim())
        return builder.toString()
    }
    return if (keyword.isBlank()) "" else keyword.trim()
}

fun wrapWordsByCharacter(keyword: String, lines: Int): String {
    return splitWords(keyword.replace("\\s+".toRegex(), " "), lines)
}

private fun splitWords(keyword: String, lines: Int): String {
    if (lines <= 1) {
        return keyword
    }

    val arrKeywords = keyword.trim { it <= ' ' }.split(" ")
    if (arrKeywords.size > 1) {
        val splitPointHigh = findSplit(keyword, lines, 1)
        val splitHigh = keyword.substring(
            0,
            splitPointHigh
        ).trim { it <= ' ' } + "\n" + splitWords(keyword.substring(splitPointHigh).trim { it <= ' ' }, lines - 1)

        val splitPointLow = findSplit(keyword, lines, -1)
        val splitLow = keyword.substring(
            0,
            splitPointLow
        ).trim { it <= ' ' } + "\n" + splitWords(keyword.substring(splitPointLow).trim { it <= ' ' }, lines - 1)

        return if (maxLineLength(splitLow) < maxLineLength(splitHigh))
            splitLow
        else
            splitHigh
    }
    return if (keyword.isBlank()) "" else keyword.trim()
}

private fun maxLineLength(split: String): Int {
    return maxLength(split.split("\n".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray())
}

private fun maxLength(lines: Array<String>): Int {
    var maxLength = 0
    for (line in lines) {
        if (line.length > maxLength)
            maxLength = line.length
    }
    return maxLength
}

private fun findSplit(input: String, lines: Int, dir: Int): Int {
    var result = input.length / lines
    while (result > 0 && input[result - 1] != ' ')
        result += dir
    return result
}





