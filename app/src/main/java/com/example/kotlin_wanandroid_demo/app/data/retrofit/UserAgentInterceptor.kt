package com.example.kotlin_wanandroid_demo.app.data.retrofit
import android.os.Parcel
import android.os.Parcelable
import com.example.kotlin_wanandroid_demo.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

/*
 * Adds a User-Agent header to the request. The header follows this format:
 * <AppName>/<version> Dalvik/<version> (Linux; U; Android <android version>; <device ID> Build/<buildtag>)
 *
 * Useful links:
 * User agents in mobile apps: https://www.scientiamobile.com/correctly-form-user-agents-for-mobile-apps
 * Test user agent: https://faisalman.github.io/ua-parser-js/
 */
class UserAgentInterceptor() : Interceptor, Parcelable {
    private val userAgent = "showcase/${BuildConfig.VERSION_NAME} ${System.getProperty("http.agent")}"

    constructor(parcel: Parcel) : this() {
    }

    override fun intercept(chain: Interceptor.Chain): Response = chain
        .request()
        .newBuilder()
        .header("User-Agent", userAgent)
        .build()
        .let { chain.proceed(it) }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserAgentInterceptor> {
        override fun createFromParcel(parcel: Parcel): UserAgentInterceptor {
            return UserAgentInterceptor(parcel)
        }

        override fun newArray(size: Int): Array<UserAgentInterceptor?> {
            return arrayOfNulls(size)
        }
    }
}
