package io.siha.study.zioEx.user.domain

import zio._

trait UserRepository {
  def register(user: User): Task[String]

  def lookup(id: String): Task[Option[User]]

  def users: Task[List[User]]
}

object UserRepository {
  def register(user: User): ZIO[UserRepository, Throwable, String] =
    ZIO.serviceWithZIO[UserRepository](_.register(user))

  def lookup(id: String): ZIO[UserRepository, Throwable, Option[User]] =
    ZIO.serviceWithZIO[UserRepository](_.lookup(id))

  def users: ZIO[UserRepository, Throwable, List[User]] =
    ZIO.serviceWithZIO[UserRepository](_.users)

}
