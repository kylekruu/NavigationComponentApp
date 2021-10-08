package com.kylekruu.proj


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation


class MainFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.view_hello).setOnClickListener(this)
        view.findViewById<Button>(R.id.enter_name_btn).setOnClickListener(this)
        view.findViewById<Button>(R.id.view_balance_btn).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.view_hello -> navController.navigate(R.id.action_mainFragment_to_viewHelloFragment)
            R.id.enter_name_btn -> navController.navigate(R.id.action_mainFragment_to_enterNameFragment)
            R.id.view_balance_btn -> navController.navigate(R.id.action_mainFragment_to_viewBalanceFragment)
        }
    }

}
