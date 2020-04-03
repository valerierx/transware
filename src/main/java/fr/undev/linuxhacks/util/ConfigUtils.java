package fr.undev.linuxhacks.util;

import fr.undev.linuxhacks.util.FileUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.FileReader;

public abstract class ConfigUtils {

	    private File file;

	    private JsonObject jsonObject;

	    public ConfigUtils(File file) {
	        this.file = file;
	    }

	    public File getFile() {
	        return file;
	    }

	    public void onLoad() {
	        this.jsonObject = this.convertJsonObjectFromFile();
	    }

	    public void onSave() {

	    }

	    protected void saveJsonObjectToFile(JsonObject object) {
	        File newFile = FileUtils.recreateFile(this.getFile());
	        FileUtils.saveJsonFile(newFile, object);
	    }

	    protected JsonObject convertJsonObjectFromFile() {
	        if (!this.getFile().exists())
	            return new JsonObject();

	        FileReader reader = FileUtils.createReader(this.getFile());
	        if (reader == null)
	            return new JsonObject();

	        JsonElement element = new JsonParser().parse(reader);
	        if (!element.isJsonObject())
	            return new JsonObject();

	        FileUtils.closeReader(reader);

	        return element.getAsJsonObject();
	    }

	    public JsonObject getJsonObject() {
	        return jsonObject;
	    }
	
	
	}
