package com.example.searchsongs.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.searchsongs.databinding.GridviewBinding
import com.example.searchsongs.databinding.OveriewFragmentBinding


class OverviewFragments : Fragment() {

    private  val viewModel : OverViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = OveriewFragmentBinding.inflate(inflater)

        // Allow databinding to access the Livedata

        binding.lifecycleOwner = this

        //giving binding access to the OverviewViewmodel
        binding.viewModel = viewModel

        binding.photosGrid.adapter = PhotoGridAdapter()
        return binding.root
    }

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.status.observe(viewLifecycleOwner){

        }
    }*/

}