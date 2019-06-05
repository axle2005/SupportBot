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

import com.github.axle2005.supportbot.Utils.ChannelUtil;
import com.github.axle2005.supportbot.Utils.CommandsUtil;
import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.MessageDecoration;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;


public class onMessageReceived implements MessageCreateListener {
    public static void main(String[] args) {

    }

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageAuthor().isBotUser()) return;


        Message message = event.getMessage();
        String content = message.getContent();
        // getContentRaw() is an atomic getter
        // getContentDisplay() is a lazy getter which modifies the content for e.g. console view (strip discord formatting)
        if (content.equals("!ping")) {
            TextChannel channel = event.getChannel();
            channel.sendMessage("Pong!");

        }

        if (content.startsWith(CommandsUtil.getTicket())) {

            ServerTextChannel channel = ChannelUtil.createSupportChannel(event.getServer().get(), event.getMessageAuthor().asUser().get());

            //Unable to use a single message builder, as it creates issues in the outputted log
            new MessageBuilder()
                    .append(event.getMessageAuthor().asUser().get().getMentionTag())
                    .append(" has opened a ticket")
                    .send(channel);

            new MessageBuilder()
                    .append("Contents:", MessageDecoration.BOLD, MessageDecoration.UNDERLINE)
                    .send(channel);

            new MessageBuilder()
                    .append(content.substring(CommandsUtil.getIndex(CommandsUtil.getTicket())))
                    .send(channel);


        }
    }
}
