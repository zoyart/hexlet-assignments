package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private Map<String, String> storage;

    public FileKV(Map<String, String> storage) {
        this.storage = storage;
    }

    public void set(String key, String value) {
        storage.put(key, value);
    }

    public String get(String key, String defaultValue) {
        return storage.getOrDefault(key, defaultValue);
    }

    public void unset(String key) {
        storage.remove(key);
    }

    public Map<String, String> toMap() {
        return new HashMap<>(storage);
    }

    public void setStorage(Map<String, String> storage) {
        this.storage = storage;
    }
}
// END
