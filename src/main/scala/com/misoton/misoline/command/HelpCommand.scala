package com.misoton.misoline.command

case object HelpCommand extends Command{

  override def run(args: List[String]): CommandResult = {
    println("Hi! I am a help command!")
    println("create [id] [name] [phone] [email]: Create new user as having parameters.\n" +
            "checkout [id]                     : Checkout User have [id]\n" +
            "exit                              : Exit from the MisoLine.\n" +
            "follow [phone or email]           : Follow user by phone number or email address.\n" +
            "friends                           : Show your(was check outed) friends.\n" +
            "help                              : ME!\n" +
            "message [id] [body]               : Send message [body] to [to].\n" +
            "show [id]                         : Show [id]'s talk messages.\n" +
            "users                             : Show all users.\n")
    CommandResult(CommandResult.OK, "Call Help.")
  }
}
