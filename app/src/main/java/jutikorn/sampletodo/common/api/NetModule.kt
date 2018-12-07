package jutikorn.sampletodo.common.api

import jutikorn.sampletodo.common.BASE_URL
import okhttp3.OkHttpClient
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val netModule = module {
    single { provideHttpClient() }
    single { provideTodoApi( get(), BASE_URL) }
}

private fun provideTodoApi(okHttpClient: OkHttpClient,
                           baseUrl: String): TodoApi =
    Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
        .create(TodoApi::class.java)

private fun provideHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()
}