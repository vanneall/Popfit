package com.example.popfit.view.photo_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.popfit.databinding.FragmentPhotoBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class PhotoFragment : Fragment() {

    private lateinit var binding: FragmentPhotoBinding

    private val viewModel: PhotoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhotoBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.get()?.let {
            binding.apply {
                Picasso.get().load(it)
                    .into(binding.imageImage)
            }
        }

        binding.downloadButton.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                withContext(Dispatchers.Main) {
                    binding.apply {
                        Picasso.get().load(binding.editImage.text.toString())
                            .into(binding.imageImage)
                    }
                }

                launch {
                    viewModel.load(binding.editImage.text.toString())
                }
            }

        }

    }

}