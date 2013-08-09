package org.kornel.testing.mocks;

public interface MockEngine {

    <T> T mock(Class<T> type);

}
