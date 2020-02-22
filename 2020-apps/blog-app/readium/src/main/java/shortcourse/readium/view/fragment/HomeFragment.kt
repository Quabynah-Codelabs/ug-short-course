package shortcourse.readium.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel
import shortcourse.readium.core.base.BaseFragment
import shortcourse.readium.core.model.post.Post
import shortcourse.readium.core.util.debugger
import shortcourse.readium.core.viewmodel.AccountViewModel
import shortcourse.readium.core.viewmodel.PostViewModel
import shortcourse.readium.databinding.FragmentHomeBinding
import shortcourse.readium.view.recyclerview.PostsAdapter

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : BaseFragment(), PostsAdapter.OnPostItemListener {
    private lateinit var binding: FragmentHomeBinding
    private val postViewModel by viewModel<PostViewModel>()
    private val accountViewModel by viewModel<AccountViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // Setup adapter
        val adapter = PostsAdapter(this@HomeFragment, get())
        binding.run {
            postsList.adapter = adapter
            executePendingBindings()
        }

        // Get all posts
        postViewModel.allPosts.observe(viewLifecycleOwner, Observer { posts ->
            adapter.submitList(posts)
        })

        // Check account information
        accountViewModel.currentUser.observe(viewLifecycleOwner, Observer { accountOwner ->
            if (accountOwner != null && accountOwner.firstName.isEmpty() && accountOwner.lastName.isEmpty())
                MaterialAlertDialogBuilder(requireContext()).apply {
                    setTitle("Account completion")
                    setMessage("You need to finish setting up your account")
                    setPositiveButton("Got It!") { dialog, _ ->
                        dialog.dismiss()
                        findNavController().navigate(HomeFragmentDirections.actionNavHomeToNavAccount())
                    }
                    setCancelable(false)
                    show()
                }
        })

    }

    override fun onClick(item: Post) {
        findNavController().navigate(HomeFragmentDirections.actionNavHomeToNavPost(item))
    }

    override fun onCommentClick(item: Post) {
        debugger("comment clicked")
    }

    override fun onVoteClick(item: Post) {
        debugger("vote clicked")
    }

    override fun onReportClick(item: Post) {
        debugger("report clicked")
    }

}