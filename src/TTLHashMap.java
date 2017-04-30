import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class TTLHashMap<K, V> implements Map<K, V> {
	private final HashMap<K, V> store = new HashMap<K, V>();
	private final HashMap<K, Long> timestamps = new HashMap<K, Long>();
	private final long ttl;

	public TTLHashMap(TimeUnit ttlUnit, long ttlValue) {
		this.ttl = ttlUnit.toNanos(ttlValue);
		System.out.println(ttl +" " + System.nanoTime());
	}

	@Override
	public int size() {
		return store.size();
	}

	private boolean expired(Object key) {
		return (System.nanoTime() - timestamps.get(key)) > this.ttl;
	}

	@Override
	public boolean isEmpty() {
		return store.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return store.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return store.containsKey(value);
	}

	@Override
	public V get(Object key) {
		V value = store.get(key);

		if (value != null && expired(key)) {
			timestamps.remove(key);
			store.remove(key);
			return null;
		} else {
			return value;
		}

	}

	@Override
	public V put(K key, V value) {
		timestamps.put(key, System.nanoTime());
		return store.put(key, value);
	}

	@Override
	public V remove(Object key) {
		timestamps.remove(key);
		return store.remove(key);
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
			this.put(e.getKey(), e.getValue());
		}

	}

	@Override
	public void clear() {
        timestamps.clear();
        store.clear();
	}

	@Override
	public Set<K> keySet() {
		clearExpired();
		return Collections.unmodifiableSet(store.keySet());
	}

	@Override
	public Collection<V> values() {
		clearExpired();
		return Collections.unmodifiableCollection(store.values());
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		clearExpired();
		return Collections.unmodifiableSet(store.entrySet());
	}
	
    private void clearExpired() {
        for (K k : store.keySet()) {
            this.get(k);
        }
    }

}
