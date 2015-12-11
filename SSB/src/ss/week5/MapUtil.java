package ss.week5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

public class MapUtil {
	
    public static <K, V> boolean isOneOnOne(Map<K, V> map) {
        // TODO: implement, see exercise P-5.1
    	Set<K> keys = map.keySet();
    	
    	Iterator<K> ix = keys.iterator();
    	
    	while (ix.hasNext()) {
    		K key = ix.next();
    		V value = map.get(key);
    		ix.remove();
    		map.remove(key);
    		if (map.containsValue(value)) {
    			return false;
    		}
    	}
    	return true;
    }
    public static <K, V> 
           boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
        // TODO: implement, see exercise P-5.2
        return false;
    }
    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
        // TODO: implement, see exercise P-5.3
        return null;
	}
	public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
        // TODO: implement, see exercise P-5.3
        return null;
	}
	public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
        // TODO: implement, see exercise P-5.4
        return false;
	}
	public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
        // TODO: implement, see exercise P-5.5
        return null;
	}
}
