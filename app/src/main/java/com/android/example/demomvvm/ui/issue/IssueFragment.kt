package com.android.example.demomvvm.ui.issue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.android.example.demomvvm.R
import com.android.example.demomvvm.core.base.BaseFragment
import com.android.example.demomvvm.core.util.setDisplayHomeAsUpEnabled
import com.android.example.demomvvm.core.util.setTitle
import com.android.example.demomvvm.core.util.setup
import com.android.example.demomvvm.databinding.FragmentIssueBinding
import com.android.example.demomvvm.ui.issue.adapter.IssueListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * used for displaying all the issue on the screen
 */
class IssueFragment : BaseFragment() {

    override val _viewModel: IssueViewModel by viewModel()

    private lateinit var binding: FragmentIssueBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_issue,
            container, false
        )
        binding.viewModel = _viewModel
        setHasOptionsMenu(true)
        setDisplayHomeAsUpEnabled(false)
        setTitle(getString(R.string.app_name))



        binding.refreshLayout.setOnRefreshListener {
            binding.refreshLayout.isRefreshing = false
            _viewModel.loadIssue()
        }

        return binding.root
    }

    private fun setupRecyclerView() {
        val adapter = IssueListAdapter {
            findNavController().navigate(IssueFragmentDirections.actionIssueFragmentToIssueDetailsFragment(
                it))
        }
        binding.rvIssue.setup(adapter)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        setupRecyclerView()
    }
}