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

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil {


    private static final String directory = "C:\\users\\user\\Desktop\\";

    public static File createFile(String name) {
        return new File(directory + "" + name + ".csv");
    }

    public static String getDirectory() {
        return directory;
    }

    public static String getDateTime() {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH:mm");
        Date date = new Date(System.currentTimeMillis());
        return date.toString();
    }
}
