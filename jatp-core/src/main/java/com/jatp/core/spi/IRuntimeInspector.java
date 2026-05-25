package com.jatp.core.spi;

import com.jatp.core.model.Widget;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface IRuntimeInspector {
    CompletableFuture<List<Widget>> dumpWidgetTree();
    String getCurrentScreenId();
}
