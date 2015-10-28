package com.misoton.misoline.command

import com.misoton.misoline.data.ApplicationData

case object FriendsListCommand extends Command {
  override def run(args: List[String]): CommandResult = {

    val you = ApplicationData.getCurrentUser

    val friends = you.getFriends

    println("** Your Friends **")

    for (f <- friends) {
      println(f.name)
    }

    CommandResult(CommandResult.OK, "Show friend list of " + you.id + ".")
  }
}
