package com.example.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.const.Layout
import com.example.dogglers.data.DataSource
import com.example.dogglers.model.Dog

/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int
): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

    val dataset: List<Dog> = DataSource.dogs

    /**
     * Initialize view elements
     */
    class DogCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        val itemImage: ImageView = view!!.findViewById(R.id.item_image)
        val itemTitle: TextView = view!!.findViewById(R.id.item_title)
        val itemAge: TextView = view!!.findViewById(R.id.item_age)
        val itemHobbies: TextView = view!!.findViewById(R.id.item_hobbies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {

        //  the inflated layout.
        val adapterLayout = when(layout) {
            Layout.GRID -> LayoutInflater.from(parent.context).inflate(R.layout.grid_list_item, parent, false)
            Layout.HORIZONTAL -> LayoutInflater.from(parent.context).inflate(R.layout.vertical_horizontal_list_item, parent, false)
            Layout.VERTICAL -> LayoutInflater.from(parent.context).inflate(R.layout.vertical_horizontal_list_item, parent, false)
            else -> null
        }

        return DogCardViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        val resources = context?.resources
        val dog = dataset[position]
        if (resources != null) {
            holder.itemTitle.text = dog.name
            holder.itemHobbies.text = resources.getString(R.string.dog_hobbies, dog.hobbies)
            holder.itemAge.text = resources.getString(R.string.dog_age, dog.age)
        }

        holder.itemImage.setImageResource(dog.imageResourceId)
    }
}
