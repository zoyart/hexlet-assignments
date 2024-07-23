package exercise;

import java.util.Map;

public interface KeyValueStorage {
    void set(String key, String value);
    void unset(String key);
    String get(String key, String defaultValue);
    Map<String, String> toMap();
    void setStorage(Map<String, String> storage);
}
