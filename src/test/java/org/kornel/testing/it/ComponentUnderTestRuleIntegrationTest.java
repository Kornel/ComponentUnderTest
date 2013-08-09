package org.kornel.testing.it;

import org.junit.Test;
import org.kornel.testing.annotations.ComponentUnderTest;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;

public class ComponentUnderTestRuleIntegrationTest extends TestBase {

    @ComponentUnderTest
    private TestComponent testComponent;

    @Test
    public void shouldCreateMocksAndStubMethod() {
        // given
        given(testComponent.returnDependency.bar()).willReturn("mock");

        // when
        final String foo = testComponent.foo();

        // then
        assertThat(foo).isEqualTo("mock");
    }

}
