package org.kornel.testing.it;


import org.kornel.testing.rules.ComponentUnderTestRule;

public class TestAutowiredInjectingRule extends ComponentUnderTestRule {

    @SuppressWarnings("unchecked")
    public TestAutowiredInjectingRule() {
        super(TestAutowired.class);
    }
}
