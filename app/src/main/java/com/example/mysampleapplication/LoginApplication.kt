package com.example.mysampleapplication



import android.app.Application
import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import java.lang.reflect.Type


class LoginApplication:Application() {
    lateinit var loginService: ApiInterface
    lateinit var DishService: DishApiService
    lateinit var registerService:RegisterApiInterface
    override fun onCreate() {
        super.onCreate()
        loginService=loginApi()
        DishService= initHttpApiService()
        registerService=initHttpregisterApiService()
    }
    fun loginApi(): ApiInterface
    {
        val retrofit= Retrofit.Builder()
            .baseUrl("https://android-kanini-course.cloud/eaterapp/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ApiInterface::class.java)
    }

    fun initHttpApiService():DishApiService{

        val retrofit = Retrofit.Builder()
            .baseUrl("https://android-kanini-course.cloud/eaterapp/")
            .addConverterFactory(JacksonConverterFactory.create(ObjectMapper()))
            .build()
        return retrofit.create(DishApiService::class.java)
    }
    fun initHttpregisterApiService(): RegisterApiInterface {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://android-kanini-course.cloud/eaterapp/")
            .addConverterFactory(NullOnEmptyConverterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(RegisterApiInterface::class.java)
    }

    class NullOnEmptyConverterFactory : Converter.Factory() {
        override fun responseBodyConverter(
            type: Type?,
            annotations: Array<Annotation>?,
            retrofit: Retrofit?
        ): Converter<ResponseBody, *>? {
            val delegate = retrofit!!.nextResponseBodyConverter<Any>(this, type!!, annotations!!)
            return Converter<ResponseBody, Any> {
                if (it.contentLength() == 0L) return@Converter
                delegate.convert(it)
            }
        }
    }
}






//
//import android.app.Application
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import retrofit2.converter.jackson.JacksonConverterFactory
//
//
//class LoginApplication:Application() {
//    lateinit var loginService: ApiInterface
//    lateinit var DishService:DishApiService
//    override fun onCreate() {
//        super.onCreate()
//        loginService=loginApi()
//        DishService= initHttpApiService()
//    }
//    fun loginApi(): ApiInterface
//    {
//        val retrofit= Retrofit.Builder()
//            .baseUrl("https://android-kanini-course.cloud/eaterapp/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        return retrofit.create(ApiInterface::class.java)
//
//    }
//    private fun initHttpApiService():DishApiService{
//
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://android-kanini-course.cloud/eaterapp/")
//            .addConverterFactory(JacksonConverterFactory.create())
//            .build()
//        return retrofit.create(DishApiService::class.java)
//    }
//}