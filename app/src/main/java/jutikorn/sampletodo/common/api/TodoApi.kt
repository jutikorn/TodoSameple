package jutikorn.sampletodo.common.api

import jutikorn.sampletodo.ui.main.data.Todo
import retrofit2.Call
import retrofit2.http.GET

interface TodoApi {

    @GET("todos/1")
    fun getTodos(): Call<Todo>

}