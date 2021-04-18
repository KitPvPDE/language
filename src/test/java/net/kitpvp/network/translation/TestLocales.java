package net.kitpvp.network.translation;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import net.kitpvp.json.JsonConfig;
import net.kitpvp.json.JsonReader;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestLocales {

    @Test
    public void testAllTranslations() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/locales/languages.json");
        Assert.assertNotNull("/locales/languages.json is not present", inputStream);
        JsonArray array = JsonReader.readToJson(inputStream).getAsJsonArray();

        for (JsonElement element : array) {
            String category = JsonConfig.readString(element, null, "id");

            PropertyLocaleManager localeManager = new PropertyLocaleManager(TestLocales.class, "/locales/" + category);
        }
    }
}
