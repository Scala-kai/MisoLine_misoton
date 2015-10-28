package com.misoton.misoline.command

abstract class Command {
  def run(args: List[String]): CommandResult
}
