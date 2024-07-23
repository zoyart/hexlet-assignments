package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage{
    private Map<String, String> storage;

    public InMemoryKV(Map<String, String> storage) {
        this.storage = new HashMap<>(storage);
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
