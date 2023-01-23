package com.example.coindex.presentation.coin_info

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coindex.common.Constants
import com.example.coindex.common.Constants.COIN_ID
import com.example.coindex.common.Resource
import com.example.coindex.domain.use_case.get_coin.GetCoin
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinInfoViewModel @Inject constructor (
    private val getCoinUseCase: GetCoin,
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private val _state = mutableStateOf(CoinInfoState())
    val state: State<CoinInfoState> = _state

    init {
        savedStateHandle.get<String>(Constants.COIN_ID)?.let{ coinId ->
            getCoin(coinId)
        }
    }
    private fun getCoin(coinId: String){
        getCoinUseCase(coinId).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = CoinInfoState(coin = result.data)
                }
                is Resource.Error -> {
                    _state.value = CoinInfoState(error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _state.value = CoinInfoState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}