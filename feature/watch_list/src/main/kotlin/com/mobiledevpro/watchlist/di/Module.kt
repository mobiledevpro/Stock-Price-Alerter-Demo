/*
 * Copyright 2021 | Dmitri Chernysh | http://mobile-dev.pro
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.mobiledevpro.watchlist.di

import com.mobiledevpro.rx.executor.Execution
import com.mobiledevpro.watchlist.domain.interactor.ImplWatchListInteractor
import com.mobiledevpro.watchlist.domain.interactor.WatchListInteractor
import com.mobiledevpro.watchlist.domain.usecase.GetWatchListUseCase
import com.mobiledevpro.watchlist.view.WatchListFragment
import com.mobiledevpro.watchlist.view.WatchListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * Koin module
 *
 * Created on Jan 06, 2022.
 *
 */
val featureWatchListModule = module {
    scope<WatchListFragment> {
        viewModel {
            WatchListViewModel(
                interactor = get()
            )
        }

        scoped<WatchListInteractor> {
            ImplWatchListInteractor(
                getWatchListUseCase = get()
            )
        }

        scoped {
            GetWatchListUseCase(
                threadExecutor = get(named(Execution.THREAD_IO)),
                postExecutionThread = get(named(Execution.THREAD_MAIN))
            )
        }
    }

}