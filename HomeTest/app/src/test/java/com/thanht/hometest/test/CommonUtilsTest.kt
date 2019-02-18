package com.thanht.hometest.test

import com.thanht.hometest.utils.formatLine
import org.junit.Assert.assertEquals
import org.junit.Test

class CommonUtilsTest {

    @Test
    fun `formatLine case empty`() {
        assertEquals("", formatLine(""))
        assertEquals("", formatLine("        "))
    }

    @Test
    fun `formatLine case 1 word`() {
        assertEquals("xiaomi", formatLine("xiaomi"))
        assertEquals("xiaomi", formatLine(" xiaomi"))
        assertEquals("xiaomi", formatLine("xiaomi "))
        assertEquals("xiaomi", formatLine(" xiaomi "))
    }

    @Test
    fun `formatLine case more than 1 word`() {
        assertEquals("bitis\nhunter", formatLine("bitis hunter"))
        assertEquals("bitis\nhunter", formatLine(" bitis hunter"))
        assertEquals("bitis\nhunter", formatLine("        bitis hunter"))
        assertEquals("bitis\nhunter", formatLine("bitis hunter "))
        assertEquals("bitis\nhunter", formatLine("bitis hunter        "))
        assertEquals("bitis\nhunter", formatLine(" bitis hunter "))
        assertEquals("bitis\nhunter", formatLine("     bitis hunter     "))
        assertEquals("bitis\nhunter", formatLine("bitis       hunter"))
        assertEquals("bitis\nhunter", formatLine(" bitis       hunter"))
        assertEquals("bitis\nhunter", formatLine(" bitis       hunter "))
        assertEquals("bitis\nhunter", formatLine("    bitis        hunter    "))

        assertEquals("bitis\nhunter x", formatLine("bitis hunter x"))
        assertEquals("bitis\nhunter x", formatLine(" bitis hunter x"))
        assertEquals("bitis\nhunter x", formatLine("        bitis hunter x"))
        assertEquals("bitis\nhunter x", formatLine("bitis hunter x "))
        assertEquals("bitis\nhunter x", formatLine("bitis hunter x        "))
        assertEquals("bitis\nhunter x", formatLine(" bitis hunter x "))
        assertEquals("bitis\nhunter x", formatLine("     bitis hunter x     "))
        assertEquals("bitis\nhunter x", formatLine("bitis       hunter x"))
        assertEquals("bitis\nhunter x", formatLine(" bitis       hunter x"))
        assertEquals("bitis\nhunter x", formatLine(" bitis       hunter x "))
        assertEquals("bitis\nhunter x", formatLine("    bitis        hunter x    "))

        assertEquals("anh chính là\nthanh xuân của em", formatLine("anh chính là thanh xuân của em"))
        assertEquals("anh chính là\nthanh xuân của em", formatLine(" anh chính là thanh xuân của em"))
        assertEquals("anh chính là\nthanh xuân của em", formatLine("anh chính là thanh xuân của em "))
    }
}
