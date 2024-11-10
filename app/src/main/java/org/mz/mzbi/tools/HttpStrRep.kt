package org.mz.mzbi.tools

object HttpStrRep {
    fun greet(url: String):String {
        if (url.matches("^http://.*\$".toRegex())){
            return url.replaceFirst("http","https")
        }
        return url
    }
}