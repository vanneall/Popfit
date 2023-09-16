package com.example.popfit.view.fruit_list_fragment.fruit_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.popfit.data.Fruit
import com.example.popfit.databinding.FruitListItemBinding

class FruitAdapter(var list: List<Fruit>) :
    RecyclerView.Adapter<FruitAdapter.ViewHolder>() {
    class ViewHolder(private val binding: FruitListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(fruit: Fruit) {
            binding.textViewFruitTitle.text = fruit.name
            binding.fruitInfo.text =
                "БЖУ: ${fruit.nutritions.protein}g, ${fruit.nutritions.fat}g, ${fruit.nutritions.carbohydrates}g"
        }
    }

    override fun getItemCount() = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            binding = FruitListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(fruit = list[position])
    }
}