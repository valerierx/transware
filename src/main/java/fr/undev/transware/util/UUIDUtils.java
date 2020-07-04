/*
 * Decompiled with CFR 0.149.
 *
 * Could not load the following classes:
 *  org.apache.commons.io.IOUtils
 *  org.json.simple.JSONArray
 *  org.json.simple.JSONObject
 *  org.json.simple.JSONValue
 *  org.json.simple.parser.ParseException
 *  mikk.gaming.cum
 */
package fr.undev.transware.util;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

public class UUIDUtils {
    public static String getUUID(String name) {
        String url = "https://api.mojang.com/users/profiles/minecraft/" + name;
        try {
            String UUIDJson = IOUtils.toString((URL)new URL(url), Charset.defaultCharset());
            if (UUIDJson.isEmpty()) {
                return "error";
            }
            JSONObject UUIDObject = (JSONObject)JSONValue.parseWithException((String)UUIDJson);
            return UUIDObject.get((Object)"id").toString();
        }
        catch (IOException | ParseException e) {
            e.printStackTrace();
            return "error";
        }
    }

    public static String getName(String uuid) {
        String url = "https://api.mojang.com/user/profiles/" + uuid.replace("-", "") + "/names";
        try {
            String nameJson = IOUtils.toString((URL) new URL(url), Charset.defaultCharset());
            JSONArray nameValue = (JSONArray)JSONValue.parseWithException((String)nameJson);
            String playerSlot = nameValue.get(nameValue.size() - 1).toString();
            JSONObject nameObject = (JSONObject)JSONValue.parseWithException((String)playerSlot);
            return nameObject.get((Object)"name").toString();
        }
        catch (IOException | ParseException e) {
            e.printStackTrace();
            return "error";
        }
    }
}
