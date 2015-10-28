package com.misoton.misoline.command

import com.misoton.misoline.log.Log

object CommandManager {
  val LOG_TAG = "CommandManager"

  val CMD_TEST     = "help"
  val CMD_CREATE   = "create"
  val CMD_FRIENDS  = "friends"
  val CMD_FOLLOW   = "follow"
  val CMD_MESSAGE  = "message"
  val CMD_SHOW     = "show"
  val CMD_CHECKOUT = "checkout"
  val CMD_USERS    = "users"
  val CMD_EXIT     = "exit"

  def runCommand(commandStr: String): Boolean = {
    val args: List[String] = commandStr.split(" ").toList
    val command = readCommand(args.head)
    val result = command.run(args)

    Log.i(LOG_TAG, result.message)

    result.tag match {
      case CommandResult.OK     => println()
      case CommandResult.ERR    => println(result.message)
      case CommandResult.FINISH => return true
      case _                    => return true
    }

    false
  }

  private def readCommand(name: String): Command = {
    name match {
      case CMD_TEST     => new HelpCommand
      case CMD_CREATE   => new CreateCommand
      case CMD_FRIENDS  => new FriendsListCommand
      case CMD_FOLLOW   => new FollowFriendCommand
      case CMD_MESSAGE  => new MessageCommand
      case CMD_SHOW     => new ShowCommand
      case CMD_CHECKOUT => new CheckoutCommand
      case CMD_USERS    => new UsersCommand
      case CMD_EXIT     => new ExitCommand
      case _            => new UndefinedCommand
    }
  }
}
