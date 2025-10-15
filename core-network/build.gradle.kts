/*
 * Designed and developed by 2024 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

plugins {
  id("skydoves.android.library")
  id("skydoves.android.hilt")
  id("skydoves.spotless")
  id(libs.plugins.google.secrets.get().pluginId)
}

android {
  namespace = "com.skydoves.chatgpt.core.network"

  buildFeatures {
    buildConfig = true
  }
}

dependencies {
  implementation(project(":core-model"))
  implementation(project(":core-preferences"))

  implementation(libs.androidx.startup)
  implementation(libs.stream.log)

  api(libs.okhttp.logging)
  api(libs.retrofit.core)
  api(libs.retrofit.moshi.converter)
  api(libs.sandwich)
}

secrets {
  propertiesFileName = "secrets.properties"
  defaultPropertiesFileName = "secrets.defaults.properties"
}