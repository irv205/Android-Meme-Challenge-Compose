package com.kk.memechallengecompose.ui.main

import com.kk.memechallengecompose.core.utils.ResponseHandler
import com.kk.memechallengecompose.data.repository.RepositoryImp
import com.kk.memechallengecompose.domain.model.Meme
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


class MainViewModelTest{

    @RelaxedMockK
    private lateinit var repository: RepositoryImp

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
    }

    @Test
    fun `when the api return a List`() = runBlocking{

        val memeList = listOf(Meme(name = "Test", "url"))
        //Given
        coEvery { repository.getMemes() } returns ResponseHandler.Success(memeList)

        //When
        val result = repository.getMemes()

        //Then
        coVerify(exactly = 1) { repository.getMemes() }
    }

    @Test
    fun `When the API returns an empty list`() = runBlocking {

        //Given
        coEvery { repository.getMemes() } returns ResponseHandler.Success(emptyList())

        //When
        val result = repository.getMemes()

        //Then
        coVerify(exactly = 1) { repository.getMemes() }
    }

    @Test
    fun `When the API returns an error`() = runBlocking {

        val message = "Test error"

        //Given
        coEvery { repository.getMemes() } returns ResponseHandler.Error(message)

        //When
        val result = repository.getMemes()

        //Then
        coVerify(exactly = 1) { repository.getMemes() }
    }

}