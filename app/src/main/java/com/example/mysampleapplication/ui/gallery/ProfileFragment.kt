package com.example.mysampleapplication.ui.gallery

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.mysampleapplication.AccountDeleteActivity
import com.example.mysampleapplication.ChangeEmailActivity
import com.example.mysampleapplication.LoginhistoryActivity
import com.example.mysampleapplication.R

class ProfileFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        view.findViewById<Button>(R.id.history).setOnClickListener {
            val intent = Intent(context, LoginhistoryActivity::class.java)
            startActivity(intent)
        }
        view.findViewById<Button>(R.id.changeMail).setOnClickListener {
            val intent = Intent(context, ChangeEmailActivity::class.java)
            startActivity(intent)
        }
        view.findViewById<Button>(R.id.deleteBtn).setOnClickListener {
            val intent = Intent(context, AccountDeleteActivity::class.java)
            startActivity(intent)
        }

        return view

    }


}