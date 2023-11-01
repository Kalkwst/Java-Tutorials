package sitecore.sherpa.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.Collection;

public class HashMapExamples {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", null); // Null value
        map.put(null, "5"); // Null key

        String value = map.get("3");
        System.out.println("Key: 3, Value: " + value);

        value = map.getOrDefault("5", "Default Value");
        System.out.println("Key: 5, Value: " + value);

        boolean keyExists = map.containsKey(null);
        boolean valueExists = map.containsValue("5");
        System.out.println("keyExists: " + keyExists + ", valueExists: " + valueExists);

        Set<Entry<String, String>> entrySet = map.entrySet();
        System.out.println(entrySet);

        System.out.println("Map Size: "+ map.size());

        Map<String, String> map1 = new HashMap<>();
        map1.putAll(map);
        System.out.println("Map1 mappings: "+map1);

        String nullKeyValue = map1.remove(null);
        System.out.println("Map1 null key value: " + nullKeyValue);
        System.out.println("Map1 after removing null key: "+ map1);

        Set<String> keySet = map.keySet();
        System.out.println("Map keys: "+ keySet);

        Collection<String> values = map.values();
        System.out.println("Map values: "+values);

        map.clear();
        System.out.println("Map is empty: "+map.isEmpty());
    }
}
