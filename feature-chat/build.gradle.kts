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
import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
  id("skydoves.android.library")
  id("skydoves.android.library.compose")
  id("skydoves.android.feature")
  id("skydoves.android.hilt")
  id("skydoves.spotless")
  id(libs.plugins.google.secrets.get().pluginId)
}

android {
  namespace = "com.skydoves.chatgpt.feature.chat"

  buildFeatures {
    buildConfig = true
  }
}

dependencies {
  // Stream chat Compose
  api(libs.stream.compose)
  api(libs.stream.offline)

  implementation(libs.androidx.lifecycle.runtimeCompose)
  implementation(libs.androidx.lifecycle.viewModelCompose)
  implementation(libs.androidx.startup)

  implementation(libs.androidx.worker)
  implementation(libs.viewmodel.lifecycle)
  implementation(libs.hilt.worker)

  implementation(libs.balloon.compose)
}

secrets {
  propertiesFileName = "secrets.properties"
  defaultPropertiesFileName = "secrets.defaults.properties"
}