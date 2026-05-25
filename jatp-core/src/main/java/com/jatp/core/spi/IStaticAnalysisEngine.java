package com.jatp.core.spi;

import com.jatp.core.model.Screen;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public interface IStaticAnalysisEngine {
    Map<String, Screen> analyzeSource(Path sourcePath) throws IOException;
}
