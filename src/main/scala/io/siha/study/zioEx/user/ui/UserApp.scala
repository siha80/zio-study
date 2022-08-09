package io.siha.study.zioEx.user.ui

import zhttp.http.*
import zio.*
import zio.json.*
import io.siha.study.zioEx.user.domain.{User, UserRepository}

object UserApp {
  def apply: Http[UserRepository, Throwable, Request, Response] =
    Http.collectZIO[Request] {
      case req@(Method.POST -> !! / "users") =>
        for {
          u <- req.bodyAsString.map(_.fromJson[User])
          res <- u match {
            case Left(e) =>
              ZIO.debug(s"Failed json deserialzation...: $e").as(
                Response.text(e.toString).setStatus(Status.BadRequest)
              )
            case Right(u) =>
              UserRepository.register(u)
                .map(id => Response.text(id))
          }
        } yield res
      // GET /users/:id
      case Method.GET -> !! / "users" / id =>
        UserRepository.lookup(id)
          .map {
            case Some(user) =>
              Response.json(user.toJson)
            case None =>
              Response.status(Status.NotFound)
          }
      case Method.GET -> !! / "users" =>
        UserRepository.users.map(userList => Response.json(userList.toJson))
    }
}
