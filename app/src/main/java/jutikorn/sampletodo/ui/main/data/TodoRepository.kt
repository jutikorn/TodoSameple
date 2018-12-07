package jutikorn.sampletodo.ui.main.data

import android.arch.lifecycle.MutableLiveData
import jutikorn.sampletodo.common.ResponseError
import jutikorn.sampletodo.common.ResponseResult
import jutikorn.sampletodo.common.api.TodoApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TodoRepository(private val api: TodoApi) {

    fun getTodos(): ResponseResult<Todo> {
        val data = MutableLiveData<Todo>()
        val error = MutableLiveData<ResponseError>()
        api.getTodos().enqueue(object : Callback<Todo> {
            override fun onResponse(call: Call<Todo>, response: Response<Todo>) {
                if (response.isSuccessful) {
                    data.value = response.body()
                } else {
                    error.value = ResponseError(response.code(), response.errorBody()?.string())
                }
            }

            override fun onFailure(call: Call<Todo>, t: Throwable) {
                error.value = ResponseError()
            }
        })
        return ResponseResult(data, error)
    }
}