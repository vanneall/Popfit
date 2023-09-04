package com.example.popfit.view.main_fragment.recycler_view_configurator

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.popfit.R
import com.example.popfit.databinding.ExerciseListItemBinding
import com.example.popfit.domain.Exercise

class ExerciseAdapter(private val clickListener: OnAdapterItemClickListener) :
    ListAdapter<Exercise, ExerciseAdapter.ExerciseViewHolder>(DiffUtilItem()) {

    class ExerciseViewHolder(
        private val binding: ExerciseListItemBinding,
        private val context: Context,
        private val clickListener: OnAdapterItemClickListener
    ) : ViewHolder(binding.root) {
        fun bind(exercise: Exercise) {
            binding.root.setOnClickListener {
                clickListener.onClick(exercise)
            }
            binding.textViewExerciseTitle.text = exercise.title
            binding.textViewExerciseCompactInfo.text = context.resources.getString(
                R.string.current_exercise_weight_cardview,
                String.format("%.3f", exercise.currentWeighInKg),
                "кг"
            )
            if (exercise.upWeightInNextTime) binding.textViewExerciseCompactInfo.setTextColor(
                context.resources.getColor(
                    R.color.green
                )
            )
        }
    }

    class DiffUtilItem : DiffUtil.ItemCallback<Exercise>() {
        override fun areItemsTheSame(oldItem: Exercise, newItem: Exercise) = oldItem == newItem

        override fun areContentsTheSame(oldItem: Exercise, newItem: Exercise) = oldItem == newItem

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        return ExerciseViewHolder(
            ExerciseListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), parent.context,
            clickListener
        )
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}