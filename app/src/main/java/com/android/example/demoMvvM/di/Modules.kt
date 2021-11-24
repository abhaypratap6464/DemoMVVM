package com.android.example.demoMvvM.di


import com.android.example.demoMvvM.data.DemoDataSource
import com.android.example.demoMvvM.data.DemoRepository
import com.android.example.demoMvvM.data.local.DemoDatabase
import com.android.example.demoMvvM.data.remote.DemoApi
import com.android.example.demoMvvM.ui.issue.IssueViewModel
import com.android.example.demoMvvM.ui.issueDetails.IssueDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val databaseModule = module {
    single { DemoDatabase.getInstance(get()).demoDao }
    single { DemoDatabase.getInstance(get()).remoteKeyDao }
    single { DemoDatabase.getInstance(get()) }
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
            get(), get(), get()
        )
    }
}

val issueDetailViewModel = module {
    viewModel {
        IssueDetailsViewModel(
            get(), get()
        )
    }
}



