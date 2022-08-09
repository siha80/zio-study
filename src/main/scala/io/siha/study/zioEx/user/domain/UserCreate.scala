package io.siha.study.zioEx.user.domain

import java.util.UUID
import zio.json._

case class UserCreate(name: String, age: Int)

object UserCreate {
  implicit val encoder: JsonEncoder[UserCreate] =
    DeriveJsonEncoder.gen[UserCreate]
  implicit val decoder: JsonDecoder[UserCreate] =
    DeriveJsonDecoder.gen[UserCreate]
}
