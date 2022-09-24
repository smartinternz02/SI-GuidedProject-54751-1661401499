package com.example.nigerianlunchtray.ui.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.nigerianlunchtray.R
import com.example.nigerianlunchtray.databinding.FragmentStartOrderBinding

/**
 * The start of an order
 */
class StartOrderFragment : Fragment() {
    // Binding object instance corresponding to fragment_start_order.xml layout
    private var _binding: FragmentStartOrderBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartOrderBinding.inflate(inflater, container, false)

        // Navigate to main menu
        binding.startOrderButton.setOnClickListener {
            findNavController().navigate(R.id.action_startOrderFragment_to_mainMenuFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

        // Clear the binding object
        _binding = null
    }
}
