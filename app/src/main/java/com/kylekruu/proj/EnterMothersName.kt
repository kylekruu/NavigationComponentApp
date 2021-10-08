package com.kylekruu.proj

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_enter_mothers_name.*


class EnterMothersName : Fragment(), View.OnClickListener {

    lateinit var navController: NavController
    lateinit var yourName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        yourName = arguments!!.getString("yourName")


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_enter_mothers_name, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.enter_btn).setOnClickListener(this)
        view.findViewById<Button>(R.id.cancel_btn).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.enter_btn -> {
                if(!TextUtils.isEmpty(input_mothers_name.text.toString())){
                    val amount = input_mothers_name.text.toString()
                    val bundle = bundleOf(
                        "yourName" to yourName,
                        "mothersName" to amount
                    )
                    navController!!.navigate(
                        R.id.action_enterMothersName_to_confirmationFragment,
                        bundle
                    )
                }
                else{
                    Toast.makeText(activity, "Enter Mother's Name", Toast.LENGTH_SHORT).show()
                }
            }

            R.id.cancel_btn -> activity!!.onBackPressed()
        }
    }
}
