package jutikorn.sampletodo.common

import android.arch.lifecycle.LiveData

data class ResponseError(val code: Int? = null, val messages: String? = null)

data class ResponseResult<T>(val data: LiveData<T>, val error: LiveData<ResponseError>)

