package io.siha.study.zioEx.greet.ui

import zhttp.http._

object GreetingApp {
  def apply(): Http[Any, Nothing, Request, Response] =
    Http.collect[Request] {
      case req@(Method.GET -> !! / "greet") if(req.url.queryParams.nonEmpty) =>
        Response.text(s"Hello ${req.url.queryParams("name").mkString(" and ")}!")
      case Method.GET -> !! / "greet" =>
        Response.text(s"Hello World!")
      case Method.GET -> !! / "greet" / name =>
        Response.text(s"Hello, $name!")
    }
}
