package io.siha.study.zioEx.user.domain

import zio.json.{DeriveJsonDecoder, DeriveJsonEncoder, JsonDecoder, JsonEncoder}

case class User(id: String, name: String, age: Int)

object User {
  implicit val encoder: JsonEncoder[User] =
    DeriveJsonEncoder.gen[User]
  implicit val decoder: JsonDecoder[User] =
    DeriveJsonDecoder.gen[User]
}
