package com.example.popfit.view.main_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.popfit.R
import com.example.popfit.databinding.FragmentMainFitnessBinding
import com.example.popfit.data.Exercise
import com.example.popfit.view.main_fragment.recycler_view_configurator.ExerciseAdapter
import com.example.popfit.view.main_fragment.recycler_view_configurator.ExerciseAdapterDecoration
import com.example.popfit.view.main_fragment.recycler_view_configurator.OnAdapterItemClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFitnessFragment : Fragment() {

    private lateinit var binding: FragmentMainFitnessBinding

    private val viewModel by viewModels<MainFitnessViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainFitnessBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val adapter = ExerciseAdapter(object : OnAdapterItemClickListener {
            override fun onClick(exercise: Exercise) {
                val bundle = Bundle()
                bundle.putParcelable("exercise", exercise)
                findNavController().navigate(
                    R.id.action_mainFitnessFragment_to_execriceInfoFragment,
                    bundle
                )
            }
        })

        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(ExerciseAdapterDecoration(50))
        viewModel.getAllExercise().observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }


        binding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.action_mainFitnessFragment_to_exerciseAddFragment)
        }


    }
}