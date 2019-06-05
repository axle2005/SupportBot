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

package com.github.axle2005.supportbot;

import com.github.axle2005.supportbot.Listeners.RegisterListeners;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.server.Server;

import javax.security.auth.login.LoginException;

public class SupportBot {


    public static void main(String[] args) throws LoginException {


        String token = "Redacted";
        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();


        Server server = api.getServerById("573696766449418240").get();

        if (!server.getChannelCategoriesByName("Support").isEmpty()) {

            //server.getMemberById()

        }
        RegisterListeners.registerMessageRecieved(api);
        RegisterListeners.registerReactionAdded(api);
        RegisterListeners.registerMessageRecievedSupport(api);


    }


}

