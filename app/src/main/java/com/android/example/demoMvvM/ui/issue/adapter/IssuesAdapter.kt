package com.android.example.demoMvvM.ui.issue.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.example.demoMvvM.data.dto.IssuesDTO
import com.android.example.demoMvvM.databinding.ItIssueListBinding
import com.android.example.demoMvvM.ui.issue.IssueFragmentDirections


class IssuesAdapter :
    PagingDataAdapter<IssuesDTO, IssuesAdapter.IssueViewHolder>(DiffUtils) {

    class IssueViewHolder(private val binding: ItIssueListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(clickListener: View.OnClickListener, issue: IssuesDTO) {
            binding.item = issue
            binding.root.setOnClickListener(clickListener)
        }
    }

    object DiffUtils : DiffUtil.ItemCallback<IssuesDTO>() {
        override fun areItemsTheSame(oldItem: IssuesDTO, newItem: IssuesDTO): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: IssuesDTO, newItem: IssuesDTO): Boolean {
            return oldItem == newItem
        }

    }

    override fun onBindViewHolder(holder: IssueViewHolder, position: Int) {
        val issue = getItem(position)
        if (issue != null) {
            holder.bind(createOnClickListener(issue), issue)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IssueViewHolder {
        return IssueViewHolder(ItIssueListBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    private fun createOnClickListener(
        issue: IssuesDTO,
    ): View.OnClickListener {
        return View.OnClickListener {
            val directions =
                IssueFragmentDirections.actionIssueFragmentToIssueDetailsFragment(issue)
            it.findNavController().navigate(directions)
        }
    }
}