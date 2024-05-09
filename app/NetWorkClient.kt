
import android.app.VoiceInteractor
import org.json.JSONObject
import java.io.IOException
import java.sql.DriverManager.println
import javax.security.auth.callback.Callback

fun searchImages(query: String) {
    val url = "https://dapi.kakao.com/v2/search/image"
    val client = OkHttpClient()

    val request = VoiceInteractor.Request.Builder()
        .url(url)
        .addHeader("Authorization", "KakaoAK YOUR_APP_REST_API_KEY")
        .get()
        .build()

    client.newCall(request).enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            e.printStackTrace()
        }

        override fun onResponse(call: Call, response: Response) {
            response.body?.string()?.let { responseBody ->
                val json = JSONObject(responseBody)
                // 여기서 검색 결과를 처리하고 필요한 정보를 추출합니다.
                println(json)
            }
        }
    })
}

fun main() {
    val query = "사자"
    searchImages(query)
}