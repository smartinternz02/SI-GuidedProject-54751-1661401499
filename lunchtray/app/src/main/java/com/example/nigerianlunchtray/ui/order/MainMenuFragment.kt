package com.example.nigerianlunchtray.ui.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.nigerianlunchtray.R
import com.example.nigerianlunchtray.databinding.FragmentMainMenuBinding
import com.example.nigerianlunchtray.model.OrderViewModel

/**
 * The main menu of an order
 */
class MainMenuFragment : Fragment() {
    // Binding object instance corresponding to fragment_main_menu.xml layout
    private var _binding: FragmentMainMenuBinding? = null
    val binding get() = _binding!!

    private val _sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize binding variables
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = _sharedViewModel
            mainMenuFragment = this@MainMenuFragment
        }
    }

    /**
     * Navigate to soup or meat menu fragments depending on main selected.
     */
    fun goToNextScreen() {
        when(_sharedViewModel.main.value?.name) {
            "Fried Rice", "Jollof Rice" -> {
                findNavController().navigate(R.id.action_mainMenuFragment_to_meatMenuFragment)
            }
            "Rice and Beans", "White Rice" -> {
                _sharedViewModel.setSoup("tomato_stew")
                findNavController().navigate(R.id.action_mainMenuFragment_to_meatMenuFragment)
            }
            else -> {
                findNavController().navigate(R.id.action_mainMenuFragment_to_soupMenuFragment)
            }
        }
    }

    /**
     * Cancel the order and start over.
     */
    fun cancelOrder() {
        // Reset order
        _sharedViewModel.resetOrder()

        // Navigate back to the [StartOrderFragment] to start over
        findNavController().navigate(R.id.action_mainMenuFragment_to_startOrderFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        // Clear the binding object
        _binding = null
    }
}
