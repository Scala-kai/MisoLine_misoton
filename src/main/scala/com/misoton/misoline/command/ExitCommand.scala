package com.misoton.misoline.command

class ExitCommand extends Command {
  val ARG_SIZE = 0

  override def run(args: List[String]): CommandResult = {
    if (args.size < ARG_SIZE + 1) {
      return CommandResult(CommandResult.ERR, "Number of argument error.")
    }

    CommandResult(CommandResult.FINISH, "Finish.")
  }
}
