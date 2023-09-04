package com.example.popfit.view.add_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.popfit.R
import com.example.popfit.databinding.FragmentExerciseAddBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExerciseAddFragment : Fragment() {

    private lateinit var binding: FragmentExerciseAddBinding

    private val viewModel by viewModels<AddViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExerciseAddBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imageViewBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.fab.setOnClickListener {
            viewModel.insertUser(
                title = binding.textInputTitle.text.toString(),
                weight = binding.textInputWeight.text.toString().toFloat()
            )
            Snackbar.make(
                binding.root,
                resources.getString(R.string.exercise_added),
                Snackbar.LENGTH_LONG
            ).show()
            findNavController().popBackStack()
        }
    }

}