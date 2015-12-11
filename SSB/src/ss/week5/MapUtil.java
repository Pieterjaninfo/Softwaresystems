package ss.week5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class MapUtil {
	
	//@ requires map != null;
	//@ ensures (\forall K k1, k2; map.containsKey(k1) && map.containsKey(k2); k1 != k2 ==> map.get(k1) != map.get(k2));
    public static <K, V> boolean isOneOnOne(Map<K, V> map) {
    	assert map != null;
    	List<V> values = new ArrayList<V>();  	
    	for (K key : map.keySet()) {
    		if (values.contains(map.get(key))) {
    			return false;
    		}
    		values.add(map.get(key));
    	}
    	return true;

    	/*Set<K> keys = map.keySet();
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
    	return true;*/
    }
    
    //@ ensures (\forall V v1; range.containsValue(V); (\exists K k1; map.containsKey(k1); V == map.get(k1)));
    public static <K, V> boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
    	for (V value : range) {
    		if (!map.containsValue(value)) {
    			return false;
    		}
    	}
        return true;
    }
    //elke key kan meerdere values hebben, vandaar set<K>.
    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
        // TODO: implement, see exercise P-5.3
    	
    	Map<V, Set<K>> result = new HashMap<V, Set<K>>();
    	for (K key : map.keySet()) {
    		
    		
    	}
    	
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
