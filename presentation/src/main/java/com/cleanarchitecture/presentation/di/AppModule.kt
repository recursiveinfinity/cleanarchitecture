package com.cleanarchitecture.presentation.di

import androidx.appcompat.app.AppCompatActivity
import com.cleanarchitecture.data.api.AlbumsApi
import com.cleanarchitecture.data.api.SearchApi
import com.cleanarchitecture.data.api.StoreApi
import com.cleanarchitecture.data.datastore.AlbumRemoteDataStore
import com.cleanarchitecture.data.datastore.RichRelevanceRemoteDataStore
import com.cleanarchitecture.data.datastore.SearchRemoteDataStore
import com.cleanarchitecture.data.datastore.StoreRemoteDataStore
import com.cleanarchitecture.data.mappers.PromotedItemMapper
import com.cleanarchitecture.data.repository.AlbumsRepositoryImpl
import com.cleanarchitecture.data.repository.PromotedItemsRepositoryImpl
import com.cleanarchitecture.data.repository.SearchRepositoryImpl
import com.cleanarchitecture.data.repository.StoreRepositoryImpl
import com.cleanarchitecture.domain.albums.AlbumsRepository
import com.cleanarchitecture.domain.albums.GetAlbumsUseCase
import com.cleanarchitecture.domain.common.Mapper
import com.cleanarchitecture.domain.home.DomainPromotedItem
import com.cleanarchitecture.domain.home.GetPromotedItemsUseCase
import com.cleanarchitecture.domain.home.PromotedItemsRepository
import com.cleanarchitecture.domain.products.StoreRepository
import com.cleanarchitecture.domain.products.GetProductsUseCase
import com.cleanarchitecture.domain.searchnavigation.GetProductsBySearchAsYouTypeUseCase
import com.cleanarchitecture.domain.searchnavigation.GetProductsBySearchAutocompleteUseCase
import com.cleanarchitecture.domain.searchnavigation.GetProductsBySearchNavigationUseCase
import com.cleanarchitecture.domain.searchnavigation.SearchRepository
import com.cleanarchitecture.presentation.albums.AlbumsViewModel
import com.cleanarchitecture.presentation.common.AsyncSingleTransformer
import com.cleanarchitecture.presentation.common.ErrorUiMapper
import com.cleanarchitecture.presentation.common.FragmentsTransactionsManager
import com.cleanarchitecture.presentation.home.HomeViewModel
import com.cleanarchitecture.presentation.mappers.AlbumUiMapper
import com.cleanarchitecture.presentation.mappers.PromotedItemUiMapper
import com.cleanarchitecture.presentation.mappers.ProductListingMapper
import com.cleanarchitecture.presentation.mappers.SearchNavigationUiMapper
import com.cleanarchitecture.presentation.navigation.AppNavigator
import com.cleanarchitecture.presentation.products.ProductsViewModel
import com.cleanarchitecture.presentation.products.UiProductMapper
import com.cleanarchitecture.presentation.search.SearchViewModel
import com.cleanarchitecture.presentation.splash.SplashViewModel
import com.richrelevance.recommendations.RecommendedProduct
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit

val repositoryModules = module {
    single { AlbumRemoteDataStore(api = get()) }
    single { RichRelevanceRemoteDataStore() }
    single { SearchRemoteDataStore(api = get()) }
    single { StoreRemoteDataStore(api = get()) }

    single<AlbumsRepository> { AlbumsRepositoryImpl(remote = get()) }
    single<PromotedItemsRepository> {
        PromotedItemsRepositoryImpl(remoteDataStore = get(),
                promotedItemMapper = get())
    }
    single<SearchRepository> { SearchRepositoryImpl(remote = get()) }
    single<StoreRepository> { StoreRepositoryImpl(remote = get()) }
}

val useCaseModules = module {
    //TODO remove  albums
    factory { GetAlbumsUseCase(transformer = AsyncSingleTransformer(), repositories = get()) }
    factory {
        GetPromotedItemsUseCase(transformer = AsyncSingleTransformer(),
                promotedItemsRepository = get())
    }
    factory { GetProductsBySearchNavigationUseCase(transformer = AsyncSingleTransformer(), repositories = get()) }
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

    single { (get(RETROFIT_INSTANCE1) as Retrofit).create(AlbumsApi::class.java) }
    single { (get(RETROFIT_INSTANCE2) as Retrofit).create(SearchApi::class.java) }
    single { (get(RETROFIT_INSTANCE3) as Retrofit).create(StoreApi::class.java) }
}

val viewModels = module {
    viewModel {
        AlbumsViewModel(getAlbumsUseCase = get(), mapper = AlbumUiMapper(), uiErrorMapper = ErrorUiMapper())
    }
    viewModel {
        SplashViewModel(uiErrorMapper = ErrorUiMapper())
    }
    viewModel {
        SearchViewModel(getProductsBySearchNavigationUseCase = get(), mapper = SearchNavigationUiMapper(), uiErrorMapper = ErrorUiMapper())
    }
    viewModel {
        HomeViewModel(getPromotedItemUseCase = get(), mapper = PromotedItemUiMapper(),
                uiErrorMapper = ErrorUiMapper())
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

val mappers = module {
    single<Mapper<RecommendedProduct, DomainPromotedItem>> { PromotedItemMapper() }
}

private const val BASE_URL1 = "https://jsonplaceholder.typicode.com/"
private const val BASE_URL2 = "https://api.dcg-search.com/"
private const val BASE_URL3 = "https://api.currys.co.uk/"

private const val RETROFIT_INSTANCE1 = "RETROFIT_INSTANCE1"
private const val RETROFIT_INSTANCE2 = "RETROFIT_INSTANCE2"
private const val RETROFIT_INSTANCE3 = "RETROFIT_INSTANCE3"


private const val GET_PRODUCTS_BY_SEARCHNAVIGATION_USECASE = "getProductsBySearchNavigationUseCase"
private const val GET_PRODUCTS_BY_SEARCHAUTOCOMPLETE_USECASE = "GetProductsBySearchAutocompleteUseCase"
private const val GET_PRODUCTS_BY_SEARCHASYOUTYPE_USECASE = "GetProductsBySearchAsYouTypeUseCase"

private const val GET_NEWS_USECASE = "getNewsUseCase"
