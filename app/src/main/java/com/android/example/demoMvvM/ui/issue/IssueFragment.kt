package com.android.example.demoMvvM.ui.issue

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.paging.ExperimentalPagingApi
import com.android.example.demoMvvM.R
import com.android.example.demoMvvM.core.base.BaseFragment
import com.android.example.demoMvvM.core.util.setDisplayHomeAsUpEnabled
import com.android.example.demoMvvM.core.util.setTitle
import com.android.example.demoMvvM.databinding.FragmentIssueBinding
import com.android.example.demoMvvM.ui.issue.adapter.IssueLoadStateAdapter
import com.android.example.demoMvvM.ui.issue.adapter.IssuesAdapter
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * used for displaying all the issue on the screen
 */
class IssueFragment : BaseFragment() {

    override val _viewModel: IssueViewModel by viewModel()

    private lateinit var binding: FragmentIssueBinding

    lateinit var issuesAdapter: IssuesAdapter


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

        return binding.root
    }

    @ExperimentalPagingApi
    private fun setupRecyclerView() {
        issuesAdapter = IssuesAdapter()

        binding.apply {
            rvIssue.setHasFixedSize(true)
            rvIssue.itemAnimator = null
            rvIssue.adapter = issuesAdapter.withLoadStateHeaderAndFooter(
                header = IssueLoadStateAdapter { issuesAdapter.retry() },
                footer = IssueLoadStateAdapter { issuesAdapter.retry() },
            )
        }



        lifecycleScope.launchWhenStarted {
            _viewModel.getAllDogs().collectLatest { response ->
                binding.apply {
                    rvIssue.isVisible = true
                    progressBar.isVisible = false
                }
                Log.d("main", "onCreate: $response")
                issuesAdapter.submitData(response)
            }
        }
    }

    @ExperimentalPagingApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        setupRecyclerView()
    }
}