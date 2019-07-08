package com.igorwojda.lastfm.feature.album.data

import com.igorwojda.lastfm.feature.album.FEATURE_NAME
import com.igorwojda.lastfm.feature.album.data.repository.AlbumRepositoryImpl
import com.igorwojda.lastfm.feature.album.data.retrofit.service.AlbumRetrofitService
import com.igorwojda.lastfm.feature.album.domain.repository.AlbumRepository
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit

internal val dataModule = Kodein.Module("${FEATURE_NAME}DataModule") {

    bind<AlbumRepository>() with singleton { AlbumRepositoryImpl(instance()) }

    bind() from singleton { instance<Retrofit>().create(AlbumRetrofitService::class.java) }
}
