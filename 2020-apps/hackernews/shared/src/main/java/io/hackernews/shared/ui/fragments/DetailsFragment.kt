package io.hackernews.shared.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import io.hackernews.shared.base.BaseFragment
import io.hackernews.shared.databinding.FragmentDetailsBinding

/**
 * A simple [Fragment] subclass.
 *
 */
class DetailsFragment : BaseFragment() {
    private lateinit var binding: FragmentDetailsBinding

    private val args: DetailsFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // Story
        val story = args.story

        binding.run {
            toolbar.setNavigationOnClickListener { findNavController().popBackStack() }
            this.story = story
        }

    }

}