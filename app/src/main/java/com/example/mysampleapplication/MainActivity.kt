package com.example.mysampleapplication

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mysampleapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {



    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

 //   private  lateinit var session: SessionManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setSupportActionBar(binding.appBarMain.toolbar)

//
//
//        val string = intent.getStringExtra("string")
//        val apiclient = application as LoginApplication
//        session = SessionManager(this)
//        var intent = Intent(this, LoginActivity::class.java)
//
//        var token = session.fetchAuthToken()
//        val items: MutableList<Dish_Data> = mutableListOf<Dish_Data>()
//        if (session.fetchAuthToken() != null) {
//            CoroutineScope(Dispatchers.IO).launch {
//                val result = apiclient.DishService.GetDishes("Bearer "+token)
//                var i = 0
//                withContext(Dispatchers.Main)
//                {
//                    if (result.isSuccessful) {
//                        while (i < result.body()?.dishes!!.size) {
//                            items.add(result.body()?.dishes!![i])
//                            i += 1
//                        }
//                    } else {
//                        startActivity(intent)
//                    }
//                    val recycle = findViewById<RecyclerView>(R.id.recycleView)
//                    recycle.adapter = AdapterClass(items)
//                    recycle.layoutManager = LinearLayoutManager(this@MainActivity)
//                }
//
//            }
//        } else
//            startActivity(intent)
//
//

//        val string = intent.getStringExtra("string")
//        val apiclient = application as LoginApplication
//        session = SessionManager(this)
//        var intent = Intent(this, LoginActivity::class.java)
//
//        var token = session.fetchAuthToken()
//        val items: MutableList<Dish_Data> = mutableListOf<DishData>()
//        if (session.fetchAuthToken() != null) {
//            CoroutineScope(Dispatchers.IO).launch {
//                withContext(Dispatchers.Main) {
//                    val recycle = findViewById<RecyclerView>(R.id.recycle)
//                    recycle.adapter = AdapterClass(items)
//                    recycle.layoutManager = LinearLayoutManager(this@MainActivity)
//                }
//                val result = apiclient.DishService.GetDishes("Bearer " + token)
//                var i = 0
//                if (result.isSuccessful) {
//                    while (i < result.body()?.dishes!!.size) {
//                        items.add(result.body()?.dishes!![i])
//                        i += 1
//                    }
//                } else {
//                    startActivity(intent)
//                }
//
//
//            }
//        }




        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_alldishes, R.id.nav_myorders, R.id.nav_otherusers,R.id.nav_Profile
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}