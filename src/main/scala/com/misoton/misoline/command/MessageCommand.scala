package com.misoton.misoline.command

import com.misoton.misoline.data.{Message, ApplicationData}

case object MessageCommand extends Command{
  val ARG_SIZE = 2

  override def run(args: List[String]): CommandResult = {
    if (args.size < ARG_SIZE + 1) {
      return CommandResult(CommandResult.ERR, "Number of args error.")
    }

    val you = ApplicationData.getCurrentUser

    val friendOp = you.getFriends.find(_.id == args(1))

    val messageBody = args(2)

    val friend = friendOp match {
      case Some(user) => user
      case None => return CommandResult(CommandResult.ERR, "No Such user found.")
    }

    val talk = ApplicationData.getTalkDataWithFriend(you, friend) match {
      case Some(t) => t
      case None => return CommandResult(CommandResult.ERR, "There is nothing talk data.")
    }

    talk.addMessage(Message(messageBody, you, friend))

    CommandResult(CommandResult.OK, "Send message \"" + messageBody + "\" to " + friend.id + " from " + you.id + ".")
  }
}
