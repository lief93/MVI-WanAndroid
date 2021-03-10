package com.igorwojda.showcase.library.base.presentation.navigation

import androidx.navigation.NavDirections
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class NavManagerTest {

    @MockK
    lateinit var navEventListener: (navDirections: NavDirections) -> Unit

    private lateinit var cut: NavManager

    @Before
    fun settUp() {
        MockKAnnotations.init(this)

        cut = NavManager()
    }

    @Test
    fun `when call navigate then call navigation event callback`() {
        // given
        val navDirections = mockk<NavDirections>()
        every { navEventListener.invoke(navDirections) } returns Unit

        cut.setOnNavEvent(navEventListener)

        // when
        cut.navigate(navDirections)

        // then
        verify { navEventListener.invoke(navDirections) }
    }
}
