package com.example.mysampleapplication


import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private lateinit var sessionManager: SessionManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val loginButton = findViewById<Button>(R.id.loginbutton)

        sessionManager = SessionManager(this,)

        loginButton.setOnClickListener {

            val email = findViewById<TextInputLayout>(R.id.email).editText?.text
            val password = findViewById<TextInputLayout>(R.id.password).editText?.text

            val user = UserData(email.toString(), password.toString())


            CoroutineScope(Dispatchers.IO).launch {
                val sampleApplication = application as LoginApplication
                val service = sampleApplication.loginService
                service.postData(user).enqueue(object : Callback<LoginData?> {
                    override fun onResponse(
                        call: Call<LoginData?>,
                        response: Response<LoginData?>
                    ) {
                        if (response.isSuccessful) {

                            val dishesintent = Intent(this@LoginActivity,MainActivity::class.java)
                            sessionManager.saveAuthToken(response.body()?.token)
                            intent.putExtra("string",response.body()?.token)
                            startActivity(dishesintent)

                        } else {
                        }
                    }

                    override fun onFailure(call: Call<LoginData?>, t: Throwable) {

                    }
                })
            }
        }

        findViewById<Button>(R.id.signupbutton).setOnClickListener {

            val loading = LoadingDialog(this)
            loading.startLoading()
            val handler = Handler()
            handler.postDelayed(object : Runnable {
                override fun run() {
                    loading.isDismiss()
                }
            }, 3000)
            val newScreenIntent = Intent(this, RegisterActivity::class.java)

            startActivity(newScreenIntent)

        }


    }
}


//
//import android.content.Context
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.os.Handler
//import android.widget.Button
//import com.google.android.material.textfield.TextInputLayout
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//
//class LoginActivity : AppCompatActivity() {
//
//    private lateinit var sessionManager: SessionManager
//
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_login)
//
//        val loginButton = findViewById<Button>(R.id.loginbutton)
//        val sharedPreferences=getSharedPreferences("user", Context.MODE_PRIVATE)
//        val token=sharedPreferences.getString("token",null)
//
//
//        val intent = Intent(this, MainActivity::class.java)
//        sessionManager = SessionManager(this,)
//
//        loginButton.setOnClickListener {
//
//            val email = findViewById<TextInputLayout>(R.id.email).editText?.text
//            val password = findViewById<TextInputLayout>(R.id.password).editText?.text
//
//            val user=UserData(email.toString(),password.toString())
//            val token=sharedPreferences.getString("token",null)
//
//            CoroutineScope(Dispatchers.IO).launch {
//                val sampleApplication=application as LoginApplication
//                val service=sampleApplication.loginService
//                service.postData(user).enqueue(object : Callback<LoginData?> {
//                    override fun onResponse(call: Call<LoginData?>, response: Response<LoginData?>) {
//                        if(response.isSuccessful)
//                        {
//
//                            val intent = Intent(this@LoginActivity,MainActivity::class.java)
//
//                            sessionManager.saveAuthToken(response.body()?.token)
//                            intent.putExtra("string",response.body()?.token)
//
//                            startActivity(intent)
//
//                        }
//                        else
//                        {
//                        }
//                    }
//
//                    override fun onFailure(call: Call<LoginData?>, t: Throwable) {
//
//                    }
//                })
//            }
//        }
//
//
//
//        findViewById<Button>(R.id.signupbutton).setOnClickListener {
//
//            val loading=LoadingDialog(this)
//            loading.startLoading()
//            val handler= Handler()
//            handler.postDelayed(object:Runnable{
//                override fun run(){
//                    loading.isDismiss()
//                }
//            },3000)
//            val newScreenIntent= Intent(this,RegisterActivity::class.java)
//
//            startActivity(newScreenIntent)
//
//        }
//
//
//
//    }
//}