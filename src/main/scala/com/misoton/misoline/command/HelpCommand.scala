package com.misoton.misoline.command

case object HelpCommand extends Command{
  override def run(args: List[String]): CommandResult = {
    println("Hi! I am a help command!")
    CommandResult(CommandResult.OK, "Call Help.")
  }
}
