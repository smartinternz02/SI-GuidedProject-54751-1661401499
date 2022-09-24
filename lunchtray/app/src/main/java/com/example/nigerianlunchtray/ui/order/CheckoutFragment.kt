package com.example.nigerianlunchtray.ui.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.nigerianlunchtray.R
import com.example.nigerianlunchtray.adapter.ItemAdapter
import com.example.nigerianlunchtray.databinding.FragmentCheckoutBinding
import com.example.nigerianlunchtray.model.MenuItem
import com.example.nigerianlunchtray.model.OrderViewModel
import com.google.android.material.snackbar.Snackbar

/**
 * The final stage of an order
 */
class CheckoutFragment : Fragment() {
    // Binding object instance corresponding to the fragment_checkout.xml layout
    private var _binding: FragmentCheckoutBinding? = null
    val binding get() = _binding!!

    private val _sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCheckoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize binding variables
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = _sharedViewModel
            checkoutFragment = this@CheckoutFragment
        }

        // Initialize data for recycler view.
        val tempItemsList = mutableListOf<MenuItem?>()
        _sharedViewModel.main.value?.let { tempItemsList.add(it) }
        _sharedViewModel.soup.value?.let { tempItemsList.add(it) }
        _sharedViewModel.meat.value?.let { tempItemsList.addAll(it) }
        _sharedViewModel.side.value?.let { tempItemsList.addAll(it) }
        _sharedViewModel.drink.value?.let { tempItemsList.addAll(it) }
        val menuItemList = tempItemsList.toList()

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = ItemAdapter(menuItemList)
        recyclerView.adapter = adapter

        // Changes in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true)
    }

    /**
     * Cancel the order and start over.
     */
    fun cancelOrder() {
        // Reset order
        _sharedViewModel.resetOrder()

        // Navigate back to [StartOrderFragment] to start over
        findNavController().navigate(R.id.action_checkoutFragment_to_startOrderFragment)
    }

    /**
     * Submit order and navigate to home screen.
     */
    fun submitOrder() {
        // Show snackbar to "confirm" order
        Snackbar.make(binding.root, R.string.submit_order, Snackbar.LENGTH_SHORT).show()

        // Reset order
        _sharedViewModel.resetOrder()

        // Navigate back to [StartOrderFragment] to start over
        findNavController().navigate(R.id.action_checkoutFragment_to_startOrderFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        // Clear the binding object
        _binding = null
    }
}
