package com.example.seng_firebase_app

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.seng_firebase_app.databinding.FragmentFirstBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.firestore.FirebaseFirestore


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    val db = FirebaseFirestore.getInstance()


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //create a map

        binding.btnSave.setOnClickListener {

            val firstName=binding.txtFirstName.text.toString()
            val lastName=binding.txtLastName.text.toString()
            val age=binding.txtAge.text.toString().toInt()

                val user= mapOf("firstName" to firstName,"lastName" to lastName,"age" to 21)
                val res=db.collection("userCollection").document("User").set(user)



            /*
             if (TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && TextUtils.isEmpty(age.toString())) {

                Toast.makeText(this, "Please add some data.", Toast.LENGTH_SHORT).show()
            } else {
                val user= mapOf("firstName" to firstName,"lastName" to lastName,"age" to 21)
                val res=db.collection("userCollection").document("User").set(user)
                if (res!=null) {
                    Toast.makeText(FirstFragment.context, "Success", Toast.LENGTH_SHORT).show()
                }
            }
             */





        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}