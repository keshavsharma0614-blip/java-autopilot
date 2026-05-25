package com.jatp.analyzer.staticanalysis;

import com.jatp.core.model.Screen;
import com.jatp.core.model.Widget;
import com.jatp.core.spi.IStaticAnalysisEngine;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

/**
 * Stub implementation of the Static Analysis Engine for the MVP release.
 */
public class MockStaticAnalysisEngine implements IStaticAnalysisEngine {
    @Override
    public Map<String, Screen> analyzeSource(Path sourcePath) throws IOException {
        System.out.println("[MockAnalysis] Analyzing source at: " + sourcePath);
        Map<String, Screen> mockScreens = new HashMap<>();

        Widget saveBtn = new Widget("saveBtn", "Button", "root/save", "Save", "Saves data", Map.of());
        Screen mainScreen = new Screen("MAIN_SCREEN", "com.jatp.MainView", List.of(), List.of(saveBtn), List.of());

        mockScreens.put("MAIN_SCREEN", mainScreen);
        return mockScreens;
    }
}
