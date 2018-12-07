package jutikorn.sampletodo.ui.main.usecases

import jutikorn.sampletodo.ui.main.data.TodoRepository

class GetTodoUsecases(private val repository: TodoRepository) {

    operator fun invoke() = repository.getTodos()
}