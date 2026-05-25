package com.jatp.api.controllers;

import com.jatp.core.model.Widget;
import com.jatp.core.spi.IRuntimeInspector;
import com.jatp.inspector.runtime.MockSwtTreeInspector;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * REST Controller for application runtime inspection.
 */
@RestController
@RequestMapping("/api/inspector")
public class InspectorController {

    // Using the Mock inspector for the MVP build
    private final IRuntimeInspector runtimeInspector = new MockSwtTreeInspector();

    /**
     * Dumps the current SWT widget tree of the running application.
     * @return A list of discovered widgets.
     */
    @GetMapping("/widgets")
    public CompletableFuture<ResponseEntity<List<Widget>>> getWidgets() {
        return runtimeInspector.dumpWidgetTree()
                .thenApply(ResponseEntity::ok);
    }

    /**
     * Checks the current active screen ID.
     * @return The ID of the currently active screen.
     */
    @GetMapping("/current-screen")
    public ResponseEntity<String> getCurrentScreen() {
        return ResponseEntity.ok(runtimeInspector.getCurrentScreenId());
    }
}
