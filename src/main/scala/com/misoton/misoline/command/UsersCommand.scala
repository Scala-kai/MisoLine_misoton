package com.misoton.misoline.command

import com.misoton.misoline.data.ApplicationData

case object UsersCommand extends Command {
  val ARG_SIZE = 0

  override def run(args: List[String]): CommandResult = {
    if (args.size > ARG_SIZE + 1) {
      return CommandResult(CommandResult.ERR, "Number of args error.")
    }

    val users = ApplicationData.getUserData

    for(user <- users){
      println("[" + user.id + "]: " + user.name)
    }

    CommandResult(CommandResult.OK, "Show all users.")
  }
}
