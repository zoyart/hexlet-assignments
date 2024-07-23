package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static void main(String[] args) {
//        KeyValueStorage storage = new InMemoryKV(Map.of("key", "value", "key2", "value2"));
//        App.swapKeyValue(storage);
//        System.out.println(storage.toMap());
    }

    public static void swapKeyValue(KeyValueStorage storage) {
        storage.setStorage(
                storage.toMap().entrySet().stream()
                        .collect(Collectors.toMap(
                                Map.Entry::getValue,
                                Map.Entry::getKey
                        ))
        );
    }
}
// END
