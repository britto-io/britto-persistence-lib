package io.britto.persistence;

/**
 * Created by tfulton on 7/3/16.
 */
public interface Persistence<K, V> {

    /**
     * Save a data object to a store (persistent, cache, async).
     *
     * @param key
     * @param data
     * @return
     */
    void save(K key, V data);

    /**
     * Read a data object from a store.
     *
     * @param key
     * @return
     */
    V read(K key);

    /**
     * Remove a data object from a store.
     *
     * @param key
     */
    void delete(K key);
}
