package org.kornel.testing;

import org.junit.Test;
import org.kornel.testing.mocks.MockitoMockEngine;

import static org.fest.assertions.api.Assertions.assertThat;

public class MockitoMockEngineTest {

    interface Intf {

    }

    private final MockitoMockEngine mockEngine = MockitoMockEngine.getInstance();

    @Test
    public void shouldMock() {
        // given

        // when
        final Intf mock = mockEngine.mock(Intf.class);

        // then
        assertThat(mock).isNotNull(); // FIXME: better assertion?
    }

}
