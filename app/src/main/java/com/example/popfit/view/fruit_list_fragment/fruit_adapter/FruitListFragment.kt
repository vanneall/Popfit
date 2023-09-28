package com.example.popfit.view.fruit_list_fragment.fruit_adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.popfit.databinding.FragmentFruitListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FruitListFragment : Fragment(), ShowToast {

    private lateinit var binding: FragmentFruitListBinding

    private val viewModel by viewModels<FruitListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.toastShower = this
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFruitListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = FruitAdapter(emptyList())
        viewModel.allFruits.observe(viewLifecycleOwner) {
            adapter.list = it
            adapter.notifyDataSetChanged()
        }

        binding.buttonReload.setOnClickListener { viewModel.deleteFruits() }

        binding.buttonDownload.setOnClickListener { viewModel.getFruitsFromServer() }

        binding.fruitRecyclerView.adapter = adapter
        binding.fruitRecyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.VERTICAL
            )
        )

    }

    override fun makeToastAndShow(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

}