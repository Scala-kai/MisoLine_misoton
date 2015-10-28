package com.misoton.misoline.command

import com.misoton.misoline.data.ApplicationData

class ShowCommand extends Command {
  val ARG_SIZE = 1

  override def run(args: List[String]): CommandResult = {
    if (args.size < ARG_SIZE + 1) {
      return CommandResult(CommandResult.ERR, "Number of args error.")
    }

    val you = ApplicationData.getCurrentUser

    val friendOp = you.getFriends.find(_.id == args(1))

    val friend = friendOp match {
      case Some(user) => user
      case None => return CommandResult(CommandResult.ERR, "No Such user found.")
    }

    val talk = ApplicationData.getTalkDataWithFriend(you, friend) match {
      case Some(t) => t
      case None => return CommandResult(CommandResult.ERR, "There is nothing talk data.")
    }

    for (msg <- talk.messageData.take(20).reverse) {
      val check = if(msg.from == you && !msg.isChecked){
        " "
      } else {
        msg.check()
        "*"
      }
      println("(" + check + ")" + msg.body)
    }

    CommandResult(CommandResult.OK, "Show messages between " + you.id + " and " + friend.id + ".")
  }
}
