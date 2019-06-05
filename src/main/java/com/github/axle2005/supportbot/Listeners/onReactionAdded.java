/*
 *   Copyright (c) 2019 Ryan Arnold (Axle)
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, version 3.
 *
 *  This program is distributed in the hope that it will be useful, but
 *  WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 *  General Public License for more details.
 *  You should have received a copy of the GNU General Public License
 *  along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.github.axle2005.supportbot.Listeners;

import com.github.axle2005.supportbot.Utils.FileUtil;
import com.vdurmont.emoji.EmojiParser;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.reaction.ReactionAddEvent;
import org.javacord.api.listener.message.reaction.ReactionAddListener;

import java.io.File;

public class onReactionAdded implements ReactionAddListener {


    @Override
    public void onReactionAdd(ReactionAddEvent event) {
        if (!event.getServerTextChannel().get().getName().contains("support-")) return;


        if (event.getEmoji().equalsEmoji(EmojiParser.parseToUnicode(":white_check_mark:"))) {

            User user = event.getServer().get().getMemberById(Long.parseLong(event.getServerTextChannel().get().getTopic())).get();
            File file = FileUtil.createFile(event.getServerTextChannel().get().getName());


            try {
                //Sends user a copy of the transcript
                user.sendMessage(file).get();

                //Renames the file for archive purposes
                file.renameTo(FileUtil.createFile(user.getDiscriminatedName() + "-" + System.currentTimeMillis()));
            } catch (Exception e) {

            }


            //Deletes original file
            file.delete();

            //Removes the channel
            event.getServerTextChannel().get().delete();
        }
    }
}
