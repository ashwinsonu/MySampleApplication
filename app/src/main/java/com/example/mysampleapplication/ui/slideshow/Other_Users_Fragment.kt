package com.example.mysampleapplication.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mysampleapplication.R

class Other_Users_Fragment : Fragment() {



     override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
     ): View? {
        return inflater.inflate(R.layout.fragment_otherusers, container, false)

        }

}


