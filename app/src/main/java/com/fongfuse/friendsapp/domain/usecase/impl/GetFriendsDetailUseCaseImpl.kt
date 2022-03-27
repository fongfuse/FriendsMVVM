package com.fongfuse.friendsapp.domain.usecase.impl

import com.fongfuse.friendsapp.data.Status
import com.fongfuse.friendsapp.domain.mapper.toModel
import com.fongfuse.friendsapp.domain.repository.FriendsRepository
import com.fongfuse.friendsapp.domain.model.Friends
import com.fongfuse.friendsapp.domain.usecase.GetFriendsDetailUseCase
import java.io.IOException
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class GetFriendsDetailUseCaseImpl @Inject constructor(
    private val friendsRepository: FriendsRepository
) : GetFriendsDetailUseCase {

    override fun execute(apiKey: String): Flow<Status<Friends>> =
        flow {
            emit(Status.Loading)
            try {
                val data = friendsRepository.getFriendsDetail(apiKey)
                emit(Status.Success(data.toModel()))
            } catch (e: HttpException) {
                emit(
                    Status.Error(
                        errorMessage = e.message(),
                        statusCode = e.code()
                    )
                )
            } catch (e: HttpException) {
                emit(
                    Status.Error(
                        errorMessage = e.localizedMessage ?: "An unexpected error occured",
                        statusCode = null
                    )
                )
            } catch (e: IOException) {
                emit(
                    Status.Error(
                        errorMessage = "Couldn't reach server. Check your internet connection.",
                        statusCode = null
                    )
                )
            }
        }
}
