package com.misoton.misoline.command

class HelpCommand extends Command{
  override def run(args: List[String]): CommandResult = {
    println("Hi! I am a help command!")
    CommandResult(CommandResult.OK, "Call Help.")
  }
}
