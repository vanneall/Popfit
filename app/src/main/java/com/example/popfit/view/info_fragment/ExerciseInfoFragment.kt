package com.example.popfit.view.info_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.popfit.databinding.FragmentExecriceInfoBinding
import com.example.popfit.data.Exercise
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExerciseInfoFragment : Fragment() {

    private val viewModel: InfoViewModel by viewModels()

    private lateinit var binding: FragmentExecriceInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExecriceInfoBinding.inflate(
            LayoutInflater.from(context),
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var exercise: Exercise? = arguments?.getParcelable("exercise")

        if (exercise == null) {
            findNavController().popBackStack()
            return
        }

        initializePageInfo(exercise)

        binding.imageViewBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.imageViewDelete.setOnClickListener {
            viewModel.delete(exercise)
            findNavController().popBackStack()
        }

        binding.textFieldWeight.doOnTextChanged { _, _, _, _ ->
            exercise.currentWeighInKg =
                if (binding.textFieldWeight.text.toString() == "") "0".toFloat() else binding.textFieldWeight.text.toString()
                    .toFloat()
        }

        binding.switchUpNextTime.setOnCheckedChangeListener { _, b ->
            exercise.upWeightInNextTime = b
        }

        binding.buttonConfirm.setOnClickListener {
            viewModel.update(exercise)
            findNavController().popBackStack()
        }

        binding.buttonCancel.setOnClickListener {
            findNavController().popBackStack()
        }

    }

    private fun initializePageInfo(exercise: Exercise) {
        viewModel.setInitialExercise(exercise.copy())
        binding.title.text = exercise.title
        binding.textFieldWeight.setText(exercise.currentWeighInKg.toString())
        binding.switchUpNextTime.isChecked = exercise.upWeightInNextTime
    }
}