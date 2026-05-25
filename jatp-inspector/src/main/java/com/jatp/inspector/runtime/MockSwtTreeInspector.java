package com.jatp.inspector.runtime;

import com.jatp.core.model.Widget;
import com.jatp.core.spi.IRuntimeInspector;
import java.util.*;
import java.util.concurrent.CompletableFuture;

/**
 * Stub implementation of the Runtime Inspector for the MVP release.
 */
public class MockSwtTreeInspector implements IRuntimeInspector {
    @Override
    public CompletableFuture<List<Widget>> dumpWidgetTree() {
        return CompletableFuture.completedFuture(List.of(
            new Widget("w1", "Button", "root/btn1", "Save", "Saves the form", Map.of()),
            new Widget("w2", "Text", "root/txt1", "Username", null, Map.of())
        ));
    }

    @Override
    public String getCurrentScreenId() {
        return "MAIN_SCREEN";
    }
}
