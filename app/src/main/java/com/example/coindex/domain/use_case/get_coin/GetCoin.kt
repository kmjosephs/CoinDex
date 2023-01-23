package com.example.coindex.domain.use_case.get_coin

import com.example.coindex.utils.Resource
import com.example.coindex.domain.model.CoinInfo
import com.example.coindex.data.map.toCoinInfo
import com.example.coindex.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoin @Inject constructor(
    private val coinRepository: CoinRepository,
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinInfo>> = flow {

        try {
            emit(Resource.Loading())
            val coin = coinRepository.getCoinById(coinId).toCoinInfo()
            emit(Resource.Success<CoinInfo>(coin))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinInfo>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinInfo>("Could not reach server. Check internet connection"))
        }
    }
}
