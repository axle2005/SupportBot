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
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.io.FileWriter;

public class onMessageRecievedSupport implements MessageCreateListener {
    @Override
    public void onMessageCreate(MessageCreateEvent event) {

        if (!event.getServerTextChannel().get().getName().contains("support-")) return;


        String channelName = event.getServerTextChannel().get().getName();
        String fileName = channelName;
        FileWriter writer = null;
        try {

            writer = new FileWriter(FileUtil.createFile(fileName), true);
            writer.write("\n" + event.getMessageAuthor().getDisplayName() + "," + event.getMessage().getReadableContent().replace(",", " "));

            writer.close();


        } catch (Exception e) {

        }
    }
}
