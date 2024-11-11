package org.mz.mzbi.logic.network

import org.mz.mzbi.MzBiApplication
import org.mz.mzbi.logic.model.UpVideoCardDataRes
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface UpVideoBaseInfoService {
    @Headers("cookie: buvid3=AAB7855C-13F7-CE5F-91C1-A1A4A5F2723790700infoc; b_nut=1727605790; _uuid=EADE31210-95CF-E748-FD8D-63BCDC31EFE191972infoc; buvid4=66665623-F8BD-D5D1-E1C6-A1E9E26571BE92783-024092910-YKtmE8SqB%2BmEV%2FvoxO1NXKSMe7gsPv4SE6mcgps4wsnLmogppUSXcu7R2oR%2FWNVP; header_theme_version=CLOSE; enable_web_push=DISABLE; CURRENT_FNVAL=4048; SESSDATA=c2efe8e9%2C1743760527%2C843ca%2Aa1CjAlYadGfgnfYTLBheoAAESm_E0IXG_CZPt3SecSBrd_mXR8pJXYKFGLxGT-7YEU0CQSVk1BR0pSWEYybU5QVFBxb01LdXBaUHU2NXExUWVKYUtQeHRaZ2ptTnMya1BzeHFONjNxWkgyUlROaE5oSmcxM0g3UDlHT2FHaUV4R25VQV94QXJTcXp3IIEC; bili_jct=c4f288fae95d307d0f6e04ac98a49fc4; DedeUserID=301934906; DedeUserID__ckMd5=87a7b3a52103cdc2; rpdid=|(Y|RRJ|lJk0J'u~k)k|)llu; home_feed_column=4; fingerprint=b1c74fc340735f5c27162f423b2d8898; buvid_fp_plain=undefined; buvid_fp=b1c74fc340735f5c27162f423b2d8898; hit-dyn-v2=1; LIVE_BUVID=AUTO2317288030767033; CURRENT_QUALITY=120; bili_ticket=eyJhbGciOiJIUzI1NiIsImtpZCI6InMwMyIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MzEzNzgwNjIsImlhdCI6MTczMTExODgwMiwicGx0IjotMX0.Maisa0QdLjG_-Z-mHGZKiAPDCJbFOLO7-sZWy5wh37M; bili_ticket_expires=1731378002; PVID=2; bp_t_offset_301934906=997750739998605312; browser_resolution=433-740")
    @GET("x/web-interface/wbi/index/top/feed/rcmd")
    fun recommendVideoHomeInfo(): Call<UpVideoCardDataRes>

}