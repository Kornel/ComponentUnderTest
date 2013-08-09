package org.kornel.testing.it;

public class TestComponent {

    @TestAutowired
    TestDependency returnDependency;

    public String foo() {
        return returnDependency.bar();
    }
}
