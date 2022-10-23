package dev.ag6.gambabot;

import io.github.cdimascio.dotenv.Dotenv;

public final class Configuration {
    public static final Configuration INSTANCE = new Configuration();
    private final Dotenv dotenv = Dotenv.load();

    public String getToken() {
        return getString("TOKEN");
    }


    public long getBotOwnerIdLong() {
        return getLong("BOT_OWNER_ID");
    }

    public long getLong(String key) {
        return Long.parseLong(dotenv.get(key));
    }

    public String getString(String key) {
        return dotenv.get(key);
    }
}
