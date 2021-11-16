package com.android.example.demomvvm.di


import com.android.example.demomvvm.data.DemoDataSource
import com.android.example.demomvvm.data.DemoRepository
import com.android.example.demomvvm.data.local.LocalDB
import com.android.example.demomvvm.data.remote.DemoApi
import com.android.example.demomvvm.ui.issue.IssueViewModel
import com.android.example.demomvvm.ui.issueDetails.IssueDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val databaseModule = module {
    single { LocalDB.createRemindersDao(get()) }
}

val apiModule = module {
    single {
        return@single DemoApi.createRetrofitService()
    }
}

val repositoryModule = module {
    single { DemoRepository(get(), get()) as DemoDataSource }
}

val issueViewModel = module {
    viewModel {
        IssueViewModel(
            get(), get(

            )
        )
    }
}

val issueDetailViewModel = module {
    viewModel {
        IssueDetailsViewModel(
            get(),get()
        )
    }
}



