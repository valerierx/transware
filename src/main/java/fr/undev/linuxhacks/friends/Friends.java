/*
 * Decompiled with CFR 0.149.
 */
package fr.undev.linuxhacks.friends;

import net.minecraft.client.Minecraft;
import org.apache.commons.io.FileUtils;

import java.io.*;

import static java.nio.charset.StandardCharsets.UTF_8;

// made by linux.
//btw thanks stackoverflow

public class Friends {
    public static boolean removeLineFromFile(String file, String lineToRemove) {

        try {

            File inFile = new File(file);

            if (!inFile.isFile()) {
                System.out.println("Parameter is not an existing file");
                return false;
            }

            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

            BufferedReader br = new BufferedReader(new FileReader(file));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line = null;

            //Read from the original file and write to the new
            //unless content matches data to be removed.
            while ((line = br.readLine()) != null) {

                if (!line.trim().equals(lineToRemove)) {

                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();

            //Delete the original file
            if (!inFile.delete()) {
                System.out.println("Could not delete file");
                return false;
            }

            //Rename the new file to the filename the original file had.
            if (tempFile.renameTo(inFile)) {
                return true;

            }else{
                return false;
            }


        }
        catch (FileNotFoundException ex) {
            System.out.println(ex);
            return false;
        }
        catch (IOException ex) {
            System.out.println(ex);
            return false;
        }
    }
    public static void addFriend(String username) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(Minecraft.getMinecraft().mcDataDir.getAbsolutePath() + "/linux.friends"));
        } catch (IOException e) {
            System.out.println(e);
        }
        pw.write(username);
        pw.close();
    }
    public static boolean isFriend(String username) {
        File file = new File(Minecraft.getMinecraft().mcDataDir.getAbsolutePath() + "/linux.friends");
        try {
            if(FileUtils.readFileToString(file, UTF_8).contains(username)) {
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }
    }

    public static boolean delFriend(String username) {
        if(isFriend(username)) {
            return removeLineFromFile(Minecraft.getMinecraft().mcDataDir.getAbsolutePath() + "/linux.friends", username);
        } else {
            return false;
        }
    }
}

