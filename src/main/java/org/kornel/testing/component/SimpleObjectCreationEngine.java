package org.kornel.testing.component;

public final class SimpleObjectCreationEngine implements ObjectCreationEngine {

    private static class Holder {
        public static final SimpleObjectCreationEngine INSTANCE = new SimpleObjectCreationEngine();
    }

    public static SimpleObjectCreationEngine getInstance() {
        return Holder.INSTANCE;
    }

    private SimpleObjectCreationEngine() {

    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T create(final Class<T> type) throws IllegalAccessException, InstantiationException {
        return type.newInstance();
    }

}
