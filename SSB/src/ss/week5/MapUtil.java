package ss.week5;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;
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
    
    //@ requires map != null;
    //@ requires range != null;
    //@ ensures (\forall V v; range.contains(v); map.containsValue(v));
    public static <K, V> boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
    	for (V value : range) {
    		if (!map.containsValue(value)) {
    			return false;
    		}
    	}
        return true;
    }
    
    /*
    //@ (\forall K; map; /result.getValue().getValue() == K);
    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
        // TODO: implement, see exercise P-5.3
    	Set<K> keys = map.keySet();
    	Collection<V> values = map.values();
    	Map<V, Set<K>> res = new HashMap<V, Set<K>>();
    	res.clear();
    	System.out.println("map: " + map + "; keys: " + keys + "; values: " + values);
    	
    	for (V value: values) {
    		if (!res.containsKey(value)) {
    			Set<K> keyRes = new HashSet<K>();
    			for (K key: keys) {
    				if (map.get(key) == value) {
    					keyRes.add(key);
    				}
    			}
    			System.out.println("value: " + value + "; keyRes: " + keyRes);
    			res.put(value, keyRes);
    			System.out.println("res: " + res);
    		}
    	}
        return res;*/
    
    //elke key kan meerdere values hebben, vandaar set<K>.
    
    //@ requires map != null;
    ///---@ ensures (\forall K k; map.keySet(); 
    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
        // TODO: implement, see exercise P-5.3
    	
    	Map<V, Set<K>> result = new HashMap<V, Set<K>>();
   		for (K key : map.keySet()) {
   			V value = map.get(key);
   			if (!result.containsKey(value)) {
   				result.put(value, new HashSet<K>());
   			}
   			result.get(value).add(key);
    	}
    	
    	return result;
	}
    
	public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
		assert isOneOnOne(map);
		Map<V, K> res = new HashMap<V, K>();
		for (K key: map.keySet()) {
			res.put(map.get(key), key);
		}
        return res;
	}
	
	public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
		Collection<V> values = f.values();
		Set<V> keys = g.keySet();
		for (V value : values) {
			if (!keys.contains(value)) {
				return false;
			}
		}
		return true;
	}
	
	public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
		assert compatible(f, g);
		Set<K> keysf = f.keySet();
		Set<V> keysg = g.keySet();
		Map<K, W> res = new HashMap<K, W>();
		for (K keyf: keysf) {
			for (V keyg: keysg) {
				if (f.get(keyf) == keyg) {
					res.put(keyf, g.get(keyg));
				}
			}
		}
		return res;
	}
}
