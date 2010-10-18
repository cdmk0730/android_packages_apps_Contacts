/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.contacts.tests.mocks;

import com.android.contacts.model.BaseAccountType;
import com.android.contacts.model.FallbackAccountType;
import com.android.contacts.model.AccountTypes;

/**
 * A mock {@link AccountTypes} class.
 */
public class MockSources extends AccountTypes {

    public static final String WRITABLE_ACCOUNT_TYPE = "writable";
    public static final String READONLY_ACCOUNT_TYPE = "readonly";

    @Override
    public BaseAccountType getInflatedSource(String accountType, int inflateLevel) {
        if (accountType.equals(WRITABLE_ACCOUNT_TYPE)) {
            BaseAccountType source = new FallbackAccountType();
            source.readOnly = false;
            return source;
        }

        if (accountType.equals(READONLY_ACCOUNT_TYPE)) {
            BaseAccountType source = new FallbackAccountType();
            source.readOnly = true;
            return source;
        }

        return null;
    }
}
