package jutikorn.sampletodo.ui.main.di

import jutikorn.sampletodo.ui.main.MainViewModel
import jutikorn.sampletodo.ui.main.data.TodoRepository
import jutikorn.sampletodo.ui.main.usecases.GetTodoUsecases
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val mainModule = module {
    viewModel { MainViewModel(get()) }
    single { GetTodoUsecases(get()) }
    single { TodoRepository(get()) }
}