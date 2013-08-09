package org.kornel.testing.component;

public interface ObjectCreationEngine {

    <T> T create(Class<T> type) throws Exception;
}
