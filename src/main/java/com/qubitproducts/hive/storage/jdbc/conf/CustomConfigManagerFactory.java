/*
 * Copyright 2012-2014 Qubit Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qubitproducts.hive.storage.jdbc.conf;

import java.util.Properties;

/**
 * Factory for creating custom config managers based on the database type
 */
public class CustomConfigManagerFactory {

    private static CustomConfigManager nopConfigManager = new NopCustomConfigManager();


    private CustomConfigManagerFactory() {
    }


    public static CustomConfigManager getCustomConfigManagerFor(DatabaseType databaseType) {
        switch (databaseType) {
            case MYSQL:
                return nopConfigManager;

            default:
                return nopConfigManager;
        }
    }

    private static class NopCustomConfigManager implements CustomConfigManager {

        @Override
        public void checkRequiredProperties(Properties properties) {
            return;
        }

    }

}