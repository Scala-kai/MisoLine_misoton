package com.misoton.misoline.command

case object ExitCommand extends Command {
  val ARG_SIZE = 0

  override def run(args: List[String]): CommandResult = {
    if (args.size < ARG_SIZE + 1) {
      return CommandResult(CommandResult.ERR, "exit : Exit from the MisoLine.")
    }

    CommandResult(CommandResult.FINISH, "Finish.")
  }
}
