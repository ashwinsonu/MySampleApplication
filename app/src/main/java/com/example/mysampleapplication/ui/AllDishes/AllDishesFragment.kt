package com.example.mysampleapplication.ui.AllDishes

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mysampleapplication.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AllDishesFragment : Fragment() {

    private  lateinit var session: SessionManager



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_alldishes, container, false)



        val string = activity?.intent?.getStringExtra("string")
        val apiclient =  activity?.application as LoginApplication
        session = SessionManager(requireContext())
        var intent = Intent(context, LoginActivity::class.java)

        var token = session.fetchAuthToken()
        val items: MutableList<Dish_Data> = mutableListOf<Dish_Data>()
        if (session.fetchAuthToken() != null) {
            CoroutineScope(Dispatchers.IO).launch {
                val result = apiclient.DishService.GetDishes("Bearer "+token)
                var i = 0
                withContext(Dispatchers.Main)
                {
                    if (result.isSuccessful) {
                        while (i < result.body()?.dishes!!.size) {
                            items.add(result.body()?.dishes!![i])
                            i += 1
                        }
                    } else {
                        startActivity(intent)
                    }
                    val recycle = view.findViewById<RecyclerView>(R.id.recycleView)
                    recycle.adapter = AdapterClass(items)
                    recycle.layoutManager = LinearLayoutManager(requireContext())
                }

            }
        } else
            startActivity(intent)



        return view



    }


    }




