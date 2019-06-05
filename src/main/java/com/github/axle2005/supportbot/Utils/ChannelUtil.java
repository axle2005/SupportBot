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

package com.github.axle2005.supportbot.Utils;

import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.channel.ServerTextChannelBuilder;
import org.javacord.api.entity.permission.PermissionState;
import org.javacord.api.entity.permission.PermissionType;
import org.javacord.api.entity.permission.Permissions;
import org.javacord.api.entity.permission.PermissionsBuilder;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;

import java.util.Random;
import java.util.concurrent.ExecutionException;

public class ChannelUtil {

    public static ServerTextChannel createSupportChannel(Server server) {

        try {


            return new ServerTextChannelBuilder(server)
                    .setCategory(server.getChannelCategoriesByName("Support").get(0))
                    .setName("Support " + (100000 + new Random().nextInt() * 900000))
                    .create()
                    .get();


        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e);
            return null;
        }


    }

    public static ServerTextChannel createSupportChannel(Server server, User user) {

        try {


            return new ServerTextChannelBuilder(server)
                    .setCategory(server.getChannelCategoriesByName("Support").get(0))
                    .setName("support " + (100000 + new Random().nextInt() * 900000))
                    .setTopic(user.getId() + "")
                    .addPermissionOverwrite(user, createPermissions())
                    .create()
                    .get();


        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e);
            return null;
        }


    }

    public static Permissions createPermissions() {
        return new PermissionsBuilder()
                .setState(PermissionType.READ_MESSAGE_HISTORY, PermissionState.ALLOWED)
                .setState(PermissionType.READ_MESSAGES, PermissionState.ALLOWED)
                .setState(PermissionType.SEND_MESSAGES, PermissionState.ALLOWED)
                .setState(PermissionType.ADD_REACTIONS, PermissionState.ALLOWED)
                .setState(PermissionType.ATTACH_FILE, PermissionState.ALLOWED)
                .setState(PermissionType.EMBED_LINKS, PermissionState.ALLOWED)
                .build();

    }
}
