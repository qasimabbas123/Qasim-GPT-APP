package com.skydoves.chatgpt

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import io.getstream.chat.android.client.ChatClient
import io.getstream.chat.android.client.logger.ChatLogLevel
import io.getstream.chat.android.state.plugin.config.StatePluginConfig
import io.getstream.chat.android.state.plugin.factory.StreamStatePluginFactory
import io.getstream.chat.android.offline.plugin.factory.StreamOfflinePluginFactory

@HiltAndroidApp
class ChatGPTApp : Application() {

  override fun onCreate() {
    super.onCreate()

    val context = this

    // ✅ Create a default config for StatePlugin
    val statePluginConfig = StatePluginConfig(
      backgroundSyncEnabled = true, // background sync enabled
      userPresence = true           // user presence tracking enabled
    )

    val statePluginFactory = StreamStatePluginFactory(
      appContext = context,
      config = statePluginConfig
    )

    val offlinePluginFactory = StreamOfflinePluginFactory(appContext = context)

    // Initialize ChatClient with plugins
    ChatClient.Builder("YOUR_STREAM_API_KEY", context)
      .withPlugins(statePluginFactory, offlinePluginFactory)
      .logLevel(ChatLogLevel.ALL)
      .build()

    // Optional: Snitcher for crash handling
    // Snitcher.install(this)
  }
}
