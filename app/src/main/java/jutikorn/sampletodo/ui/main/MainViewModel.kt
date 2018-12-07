package jutikorn.sampletodo.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import jutikorn.sampletodo.common.ResponseError
import jutikorn.sampletodo.common.ResponseResult
import jutikorn.sampletodo.common.SingleLiveEvent
import jutikorn.sampletodo.ui.main.data.Todo
import jutikorn.sampletodo.ui.main.usecases.GetTodoUsecases

class MainViewModel(private val getTodoUsecase: GetTodoUsecases) : ViewModel() {

    val _onActivityCreated = SingleLiveEvent<Any>()

    private val responseResult: LiveData<ResponseResult<Todo>> = Transformations.map(_onActivityCreated) {
        getTodoUsecase()
    }

    val todoResult: LiveData<Todo> = Transformations.switchMap(responseResult) {
        it.data
    }

    val errorResult: LiveData<ResponseError> = Transformations.switchMap(responseResult) {
        it.error
    }
}
