import kotlin.random.Random
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.jsoup.Jsoup

/**
 * Created by Ji Sungbin on 2021/08/24.
 */

fun main() = runBlocking {
    repeat(100) {
        val response = testPost()
        println(response.getOrNull())
        delay(1000)
    }
}

private fun testPost() = runCatching {
    try {
        val value = StringUtil.getRandom(Random.nextInt(50))
        Jsoup.connect("http://www.devl.es/post").data("value", "- $value").post().wholeText()
    } catch (exception: Exception) {
        exception.message
    }
}

private object StringUtil {
    fun getRandom(length: Int) = List(length) { ('가'..'힣').random() }.joinToString("")
}