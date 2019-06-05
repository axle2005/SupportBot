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

import org.javacord.api.DiscordApi;
import org.javacord.api.listener.message.MessageCreateListener;

public class RegisterListeners {

    public static void registerMessageRecieved(DiscordApi api) {
        api.addListener(new onMessageReceived());
    }

    public static void unregisterMessageRecieved(DiscordApi api) {
        api.removeListener(MessageCreateListener.class, new onMessageReceived());
    }

    public static void registerReactionAdded(DiscordApi api) {
        api.addListener(new onReactionAdded());
    }

    public static void registerMessageRecievedSupport(DiscordApi api) {
        api.addListener(new onMessageRecievedSupport());
    }


}
