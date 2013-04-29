package jp.pokemonms.util;

import org.slim3.util.Converter;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

/**
 * The converter for key.
 * 
 * @author sinmetal
 * 
 */
public class KeyConverter implements Converter<Key> {

    @Override
    public Key getAsObject(String value) {
        return KeyFactory.stringToKey(value);
    }

    @Override
    public String getAsString(Object value) {
        if (value == null) {
            return null;
        }
        if (!(value instanceof Key)) {
            throw new IllegalArgumentException("The class("
                + value.getClass().getName()
                + ") can not be assigned to date.");
        }
        return KeyFactory.keyToString((Key) value);
    }

    @Override
    public boolean isTarget(Class<?> clazz) {
        return Key.class.isAssignableFrom(clazz);
    }

}
