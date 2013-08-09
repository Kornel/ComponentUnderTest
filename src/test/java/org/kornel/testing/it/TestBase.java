package org.kornel.testing.it;

import org.junit.Rule;
import org.kornel.testing.rules.ComponentUnderTestRule;

public abstract class TestBase {

    @Rule
    public final ComponentUnderTestRule rule = new TestAutowiredInjectingRule();

}
