package jutikorn.sampletodo.ui.main.data

import com.google.gson.annotations.SerializedName

class Todo(
    @SerializedName("userId") val userId: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("completed") val completed: Boolean
)