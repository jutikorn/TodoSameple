package jutikorn.sampletodo

import android.app.Application
import jutikorn.sampletodo.common.api.netModule
import jutikorn.sampletodo.ui.main.di.mainModule
import org.koin.android.ext.android.startKoin

val applicationModule =  listOf(netModule, mainModule)

class TodosApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, applicationModule)
    }
}