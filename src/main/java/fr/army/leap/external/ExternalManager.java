package fr.army.leap.external;

import fr.army.leap.external.simpleportals.ExternalSimplePortalsLoader;

public class ExternalManager {

    private final ExternalSimplePortalsLoader externalSimplePortalsLoader;

    public ExternalManager() {
        this.externalSimplePortalsLoader = new ExternalSimplePortalsLoader();
    }

    public void load() {
        externalSimplePortalsLoader.load();
    }

    public void unload() {
        externalSimplePortalsLoader.unload();
    }
}
