package io.siha.study.zioEx

import io.siha.study.zioEx.greet.ui.GreetingApp
import zhttp.service.Server
import zio._

object MainApp extends ZIOAppDefault {
  def run = Server.start(
    port = 8080,
    http = GreetingApp()
  ).provide(
    ZLayer.fromZIO(Ref.make(0))
  )
}
