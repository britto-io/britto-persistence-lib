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
    V save(K key, V data);

    /**
     * Read a data object from a store.
     *
     * @param key
     * @return
     */
    V read(K key);

    /**
     * Update a data object kept in a store.
     *
     * @param key
     * @param data
     * @return
     */
    V update(K key, V data);

    /**
     * Remove a data object from a store.
     *
     * @param key
     */
    void delete(K key);
}
