package com.arash.altafi.arashaltafi.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arash.altafi.arashaltafi.models.ResponsePrice
import com.arash.altafi.arashaltafi.repositories.PriceRepository
import com.arash.altafi.arashaltafi.repositories.PriceRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val priceRepository: PriceRepositoryImpl) : ViewModel() {

    var priceLiveData = MutableLiveData<ResponsePrice>()
    var errorLiveData = MutableLiveData<String>()
    var progressBarLiveData = MutableLiveData<Boolean>()
    var compositeDisposable = CompositeDisposable()

    init {
        progressBarLiveData.value = true
        priceRepository.getPrice()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            //when complete set progress false
            .doFinally {
                progressBarLiveData.value = false
            }
            .subscribe(object : SingleObserver<ResponsePrice>{
                override fun onSubscribe(d: Disposable) {
                    compositeDisposable.add(d)
                }

                override fun onSuccess(t: ResponsePrice) {
                    priceLiveData.value = t
                }

                override fun onError(e: Throwable) {
                    errorLiveData.value = e.message
                }

            })

    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }

}