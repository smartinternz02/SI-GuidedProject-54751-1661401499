package com.example.nigerianlunchtray.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nigerianlunchtray.R
import com.example.nigerianlunchtray.model.MenuItem

/**
 * Adapter for [RecyclerView] in CheckoutFragment. Displays [MenuItem] data object.
 */
class ItemAdapter(
    private val _dataset: List<MenuItem?>?
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    /**
     * Get the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = _dataset?.get(position)
        holder.itemNameView.text = item!!.name
        holder.itemPriceView.text = item.getFormattedPrice()
    }

    /**
     * Return the size of the dataset (invoked by the layout manager)
     */
    override fun getItemCount() = _dataset!!.size

    /**
     * Provide a reference to the views for the name and price of each [MenuItem]
     */
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemNameView: TextView = view.findViewById(R.id.item_selection)
        val itemPriceView: TextView = view.findViewById(R.id.item_price)
    }
}
