package com.misoton.misoline.command

import com.misoton.misoline.data.ApplicationData

case object CheckoutCommand extends Command {
  val ARG_SIZE = 1

  override def run(args: List[String]): CommandResult = {
    if (args.size > ARG_SIZE + 1) {
      return CommandResult(CommandResult.ERR, "Number of args error.")
    }

    val nextId = args(1)

    ApplicationData.getUserData.find(u => u.id == nextId) match {
      case Some(user) => ApplicationData.checkoutUser(user)
      case None => return CommandResult(CommandResult.ERR, "Such user is not found.")
    }

    CommandResult(CommandResult.OK, "Checkout to " + nextId + ".")
  }
}
