package com.example.home.data.repository

import io.mockk.MockKAnnotations
import org.junit.Before
import org.junit.Test

class HomeRepositoryImplTest {

    private lateinit var cut : HomeRepositoryImpl


    @Before
    fun setup(){
        MockKAnnotations.init(this)

    }

    @Test
    fun `getAlbumInfo fetches AlbumInfo and maps to Model`(){

    }

    @Test
    fun `aaa`(){
        
    }
}