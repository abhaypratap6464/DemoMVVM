package com.android.example.demoMvvM.ui.issueDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.android.example.demoMvvM.R
import com.android.example.demoMvvM.core.base.BaseFragment
import com.android.example.demoMvvM.core.util.setDisplayHomeAsUpEnabled
import com.android.example.demoMvvM.core.util.setTitle
import com.android.example.demoMvvM.core.util.setup
import com.android.example.demoMvvM.data.dto.IssuesDTO
import com.android.example.demoMvvM.databinding.FragmnetIssueDetailBinding
import com.android.example.demoMvvM.ui.issueDetails.adapter.IssueDetailListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class IssueDetailsFragment : BaseFragment() {
    override val _viewModel: IssueDetailsViewModel by viewModel()

    private lateinit var binding: FragmnetIssueDetailBinding

    private var issuesItem: IssuesDTO? = null
    private val issueDetailsArgs by navArgs<IssueDetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragmnet_issue_detail,
            container, false
        )
        binding.viewModel = _viewModel
        binding.lifecycleOwner = this
        setHasOptionsMenu(true)
        setDisplayHomeAsUpEnabled(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        issuesItem = issueDetailsArgs.issueData
        issuesItem?.let {
            setTitle(it.title!!)
        }
        _viewModel.loadIssueDetails(issuesItem!!.comment_id!!, issuesItem!!.commentNo!!)
        setupRecyclerView()

    }

    private fun setupRecyclerView() {
        binding.rvIssueDetail.setup(IssueDetailListAdapter())
    }

}