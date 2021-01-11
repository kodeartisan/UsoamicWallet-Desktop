package io.usoamic.wallet.extensions

import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import io.usoamic.wallet.util.BuildConfig
import java.util.concurrent.TimeUnit

fun <T> Single<T>.observeOnMain(): Single<T> = observeOn(Schedulers.single())

fun <T> Single<T>.subscribeOnIo(): Single<T> = subscribeOn(Schedulers.io())

fun <T> Single<T>.addSchedulers(): Single<T> = subscribeOnIo().observeOnMain()

fun <T> Single<T>.addDebugDelay(): Single<T> {
    if(BuildConfig.DEBUG) {
        return delay(2, TimeUnit.SECONDS)
    }
    return this
}

fun Completable.addDebugDelay(): Completable {
    if(BuildConfig.DEBUG) {
        return delay(2, TimeUnit.SECONDS)
    }
    return this
}
