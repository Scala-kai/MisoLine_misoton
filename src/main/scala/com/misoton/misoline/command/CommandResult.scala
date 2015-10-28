package com.misoton.misoline.command

case class CommandResult(tag: String, message: String)

object CommandResult {
  val OK: String = "ok"
  val ERR: String = "error"
  val FINISH: String = "finish"
}