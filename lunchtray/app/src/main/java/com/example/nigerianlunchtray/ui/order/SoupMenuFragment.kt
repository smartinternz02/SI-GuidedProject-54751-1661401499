package com.example.nigerianlunchtray.ui.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.nigerianlunchtray.R
import com.example.nigerianlunchtray.databinding.FragmentSoupMenuBinding
import com.example.nigerianlunchtray.model.OrderViewModel

/**
 * The soup menu of an order
 */
class SoupMenuFragment : Fragment() {
    // Binding object instance corresponding to fragment_soup_menu.xml layout
    private var _binding: FragmentSoupMenuBinding? = null
    val binding get() = _binding!!

    private val _sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSoupMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize binding variables
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = _sharedViewModel
            soupMenuFragment = this@SoupMenuFragment
        }
    }

    /**
     * Navigate to meat menu fragment.
     */
    fun goToNextScreen() {
        // Navigate to [MeatMenuFragment]
        findNavController().navigate(R.id.action_soupMenuFragment_to_meatMenuFragment)
    }

    /**
     * Cancel the order and start over.
     */
    fun cancelOrder() {
        // Reset order
        _sharedViewModel.resetOrder()

        // Navigate back to [StartOrderFragment] to start over
        findNavController().navigate(R.id.action_soupMenuFragment_to_startOrderFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        // Clear the binding object
        _binding = null
    }
}
