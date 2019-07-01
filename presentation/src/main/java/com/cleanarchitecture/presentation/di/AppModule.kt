package com.cleanarchitecture.presentation.di

import androidx.appcompat.app.AppCompatActivity
import com.cleanarchitecture.data.api.AlbumsApi
import com.cleanarchitecture.data.api.SearchApi
import com.cleanarchitecture.data.api.StoreApi
import com.cleanarchitecture.data.datastore.AlbumRemoteDataStore
import com.cleanarchitecture.data.datastore.SearchRemoteDataStore
import com.cleanarchitecture.data.datastore.StoreRemoteDataStore
import com.cleanarchitecture.data.repository.AlbumsRepositoryImpl
import com.cleanarchitecture.data.repository.SearchRepositoryImpl
import com.cleanarchitecture.data.repository.StoreRepositoryImpl
import com.cleanarchitecture.domain.albums.AlbumsRepository
import com.cleanarchitecture.domain.albums.GetAlbumsUseCase
import com.cleanarchitecture.domain.products.GetProductsUseCase
import com.cleanarchitecture.domain.products.StoreRepository
import com.cleanarchitecture.domain.searchnavigation.GetProductsBySearchAsYouTypeUseCase
import com.cleanarchitecture.domain.searchnavigation.GetProductsBySearchAutocompleteUseCase
import com.cleanarchitecture.domain.searchnavigation.GetProductsBySearchNavigationUseCase
import com.cleanarchitecture.domain.searchnavigation.SearchRepository
import com.cleanarchitecture.presentation.albums.AlbumsViewModel
import com.cleanarchitecture.presentation.common.AsyncSingleTransformer
import com.cleanarchitecture.presentation.common.ErrorUiMapper
import com.cleanarchitecture.presentation.common.FragmentsTransactionsManager
import com.cleanarchitecture.presentation.mappers.AlbumUiMapper
import com.cleanarchitecture.presentation.mappers.ProductListingMapper
import com.cleanarchitecture.presentation.mappers.SearchNavigationUiMapper
import com.cleanarchitecture.presentation.navigation.AppNavigator
import com.cleanarchitecture.presentation.products.ProductsViewModel
import com.cleanarchitecture.presentation.products.UiProductMapper
import com.cleanarchitecture.presentation.search.SearchViewModel
import com.cleanarchitecture.presentation.splash.SplashViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit

val repositoryModules = module {
    single(name = ALBUM_REMOTE_DATASTORE) { AlbumRemoteDataStore(api = get(ALBUMS_API)) }
    single(name = SEARCH_REMOTE_DATASTORE) { SearchRemoteDataStore(api = get(SEARCH_API)) }
    single(name = STORE_REMOTE_DATASTORE) { StoreRemoteDataStore(api = get(STORE_API)) }

    single<AlbumsRepository> { AlbumsRepositoryImpl(remote = get(ALBUM_REMOTE_DATASTORE)) }
    single<SearchRepository> { SearchRepositoryImpl(remote = get(SEARCH_REMOTE_DATASTORE)) }
    single<StoreRepository> { StoreRepositoryImpl(remote = get(STORE_REMOTE_DATASTORE)) }
}

val useCaseModules = module {
    factory(name = GET_NEWS_USECASE) { GetAlbumsUseCase(transformer = AsyncSingleTransformer(), repositories = get()) }

    factory { GetProductsUseCase(transformer = AsyncSingleTransformer(), searchRepository = get(), storeRepository = get()) }

    factory(name = GET_PRODUCTS_BY_SEARCHNAVIGATION_USECASE) { GetProductsBySearchNavigationUseCase(transformer = AsyncSingleTransformer(), repositories = get()) }
    factory(name = GET_PRODUCTS_BY_SEARCHAUTOCOMPLETE_USECASE) { GetProductsBySearchAutocompleteUseCase(transformer = AsyncSingleTransformer(), repositories = get()) }
    factory(name = GET_PRODUCTS_BY_SEARCHASYOUTYPE_USECASE) { GetProductsBySearchAsYouTypeUseCase(transformer = AsyncSingleTransformer(), repositories = get()) }
}

val networkModules = module {
    single(name = RETROFIT_INSTANCE1) { createNetworkClient(BASE_URL1) }
    single(name = RETROFIT_INSTANCE2) { createNetworkClient(BASE_URL2) }
    single(name = RETROFIT_INSTANCE3) { createNetworkClient(BASE_URL3) }

    single(name = ALBUMS_API) { (get(RETROFIT_INSTANCE1) as Retrofit).create(AlbumsApi::class.java) }
    single(name = SEARCH_API) { (get(RETROFIT_INSTANCE2) as Retrofit).create(SearchApi::class.java) }
    single(name = STORE_API) { (get(RETROFIT_INSTANCE3) as Retrofit).create(StoreApi::class.java) }
}

val viewModels = module {
    viewModel {
        AlbumsViewModel(getAlbumsUseCase = get(GET_NEWS_USECASE), mapper = AlbumUiMapper(), uiErrorMapper = ErrorUiMapper())
    }
    viewModel {
        SplashViewModel(uiErrorMapper = ErrorUiMapper())
    }
    viewModel {
        SearchViewModel(getProductsBySearchNavigationUseCase = get(GET_PRODUCTS_BY_SEARCHNAVIGATION_USECASE), mapper = SearchNavigationUiMapper(), uiErrorMapper = ErrorUiMapper())
    }
    viewModel {
        ProductsViewModel(getProductsUseCase = get(), mapper = ProductListingMapper(UiProductMapper(), SearchNavigationUiMapper()), uiErrorMapper = ErrorUiMapper())
    }
}

val navigator = module {
    factory { (activity: AppCompatActivity) -> AppNavigator(activity) }
}

val fragments = module {
    factory { (activity: AppCompatActivity) -> FragmentsTransactionsManager(activity.supportFragmentManager) }
}

private const val BASE_URL1 = "https://jsonplaceholder.typicode.com/"
private const val BASE_URL2 = "https://api.dcg-search.com/"
private const val BASE_URL3 = "https://api.currys.co.uk/"

private const val RETROFIT_INSTANCE1 = "RETROFIT_INSTANCE1"
private const val RETROFIT_INSTANCE2 = "RETROFIT_INSTANCE2"
private const val RETROFIT_INSTANCE3 = "RETROFIT_INSTANCE3"

private const val ALBUMS_API = "ALBUMS_API"
private const val SEARCH_API = "SEARCH_API"
private const val STORE_API = "STORE_API"

private const val ALBUM_REMOTE_DATASTORE = "ALBUM_REMOTE_DATASTORE"
private const val SEARCH_REMOTE_DATASTORE = "SEARCH_REMOTE_DATASTORE"
private const val STORE_REMOTE_DATASTORE = "STORE_REMOTE_DATASTORE"

private const val GET_PRODUCTS_BY_SEARCHNAVIGATION_USECASE = "GET_PRODUCTS_BY_SEARCHNAVIGATION_USECASE"
private const val GET_PRODUCTS_BY_SEARCHAUTOCOMPLETE_USECASE = "GET_PRODUCTS_BY_SEARCHAUTOCOMPLETE_USECASE"
private const val GET_PRODUCTS_BY_SEARCHASYOUTYPE_USECASE = "GET_PRODUCTS_BY_SEARCHASYOUTYPE_USECASE"

private const val GET_NEWS_USECASE = "getNewsUseCase"
