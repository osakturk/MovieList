package com.example.moviecase.service.helper

import androidx.annotation.MainThread
import com.example.moviecase.service.INetworkResponseHandling
import java.lang.Exception

abstract class RequestHelper<T> {

    /**
     * @param[isNeedProgressBar] : ProgressBar'ın gösterilip gösterilmeyeceği kontrolü
     *
     * @param[INetworkResponseHandling] : Generic network response'ları handle etmek için eklenen bir interface. BaseViewModel'da bulunuyor.
     * ViewModel'ınızı BaseViewModel'dan türettiyseniz 'this' demeniz yeterli.
     */
    suspend fun loadRequest(
        iNetworkResponseHandling: INetworkResponseHandling,
        isNeedProgressBar: Boolean
    ): DataHolder<T>? {
        if (isNeedProgressBar) iNetworkResponseHandling.loading(true)
        return try {
            val response = createNetworkRequest()
            if (isNeedProgressBar) iNetworkResponseHandling.loading(false)
            DataHolder.Success(response)
        } catch (e: Exception) {
            iNetworkResponseHandling.onErrorPopUp("Error", "Your transaction is not processed now")
            DataHolder.Error("Your transaction is not processed now")
        }
    }

    @MainThread
    protected abstract suspend fun createNetworkRequest(): T
}