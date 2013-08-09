package org.kornel.testing.component;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class SimpleObjectCreationEngineTest {

    static class TestClass {

    }

    private final SimpleObjectCreationEngine engine = SimpleObjectCreationEngine.getInstance();

    @Test
    public void shouldCreateObject() throws Exception {
        // given

        // when
        final TestClass instance = engine.create(TestClass.class);

        // then
        assertThat(instance).isNotNull();
    }
}
