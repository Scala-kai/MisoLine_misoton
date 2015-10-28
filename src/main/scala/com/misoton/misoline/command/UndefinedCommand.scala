package com.misoton.misoline.command

case object UndefinedCommand extends Command{
  override def run(args: List[String]): CommandResult = {
    println("That command is undefined.")
    CommandResult(CommandResult.OK, "Call undefined command as " + args.head + ".")
  }
}
