/*
 * Copyright (c) 2022 DuckDuckGo
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
 */

package com.duckduckgo.cookies.store

import com.duckduckgo.cookies.api.CookiesFeatureName.Cookie
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class RealCookiesFeatureToggleRepositoryTest {
    lateinit var testee: RealCookiesFeatureToggleRepository

    private val mockCookiesFeatureToggleStore: CookiesFeatureToggleStore = mock()

    @Before
    fun before() {
        testee = RealCookiesFeatureToggleRepository(mockCookiesFeatureToggleStore)
    }

    @Test
    fun whenDeleteAllThenDeleteAllCalled() {
        testee.deleteAll()

        verify(mockCookiesFeatureToggleStore).deleteAll()
    }

    @Test
    fun whenGetThenGetCalled() {
        testee.get(Cookie, true)

        verify(mockCookiesFeatureToggleStore).get(Cookie, true)
    }

    @Test
    fun whenInsertThenInsertCalled() {
        val cookieFeatureToggle = CookiesFeatureToggles(Cookie, true, null)
        testee.insert(cookieFeatureToggle)

        verify(mockCookiesFeatureToggleStore).insert(cookieFeatureToggle)
    }
}
