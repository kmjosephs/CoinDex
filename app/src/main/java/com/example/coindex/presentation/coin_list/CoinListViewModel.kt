package com.example.coindex.presentation.coin_list

import androidx.lifecycle.ViewModel
import com.example.coindex.domain.use_case.get_coins.GetCoins
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor (
    private val getCoinsUseCase: GetCoins
): ViewModel() {
}