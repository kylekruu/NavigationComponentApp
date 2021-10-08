package com.kylekruu.proj


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView



class ConfirmationFragment : Fragment() {

    lateinit var yourName: String
    lateinit var mothersName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        yourName = arguments!!.getString("yourName")
        mothersName = arguments!!.getString("mothersName")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val confirmationMessage = "$mothersName is $yourName's mother"
        view.findViewById<TextView>(R.id.confirmation_message).text = confirmationMessage
    }


}
