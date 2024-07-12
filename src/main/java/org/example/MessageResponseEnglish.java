package org.example;

public class MessageResponseEnglish {
    public static String greeting = "Many blessings, click button Attendance below here to pray attendance!";
    public static String attendance_ok = "You have taken attendance and prayed for today's success. Pray diligently to God to receive God's grace!";
    public static String attendance_error = "Today's prayer roll call failed, please try again. Pray to God for help!";
    public static String attendance_btn = "Attendance";
    public static String bot_done = "Thanks, wish you have a great day!";
    public static String help_text =
            "This bot will help you take attendance, count the number of prayers as well as statistics on the number of prayers over time (quarter, week, month or year).\n" +
                    "\n" +
                    "Note that only the administrator can summarize the prayer times according to the timelines of **ALL MEMBERS**, others can only see their own information.\n" +
                    "\n" +
                    "**NOTE: THERE ARE FEATURES THAT ONLY ADMINISTRATORS CAN USE. WHEN YOU USE THESE FEATURES WHEN YOU ARE NOT AN ADMINISTRATOR, YOU WILL RECEIVE AN ERROR MESSAGE**\n" +
                    "\n" +
                    "These are the commands that the bot supports. Note that only commands are supported, if the command requires arguments, you can just enter the arguments after entering the command.\n" +
                    "\n" +
                    "**/start** - Starts the bot\n" +
                    "**/help** - Displays this help\n" +
                    "**/addquotes (ADMIN ONLY)** - Add quotes (admins only). The command requires a single argument, which is a text quote\n" +
                    "**/sum** - Provides statistics about the number of prayers. Prayer times will be accumulated and will be reset to 0 at 12:00AM on January 1. The command requires 1 argument which is the time stamp.\n" +
                    "**/showquotes** - Show quotes. Each time you use the command, a new quote will appear.";
}

