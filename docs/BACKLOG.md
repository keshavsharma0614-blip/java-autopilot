# Project Backlog & Contribution Tasks

This file serves as the roadmap-to-task translation. These issues are proposed for the GitHub Issues tab.

## 🟢 Good First Issues (Newcomers)
- [ ] **Recursive Source Scanning**: Implement recursive directory walking in `StaticAnalysisEngine.analyzeSource` to ensure all Java files are processed.
- [ ] **Markdown Test Parser**: Create a parser that converts basic Markdown test cases into `TestCase` records.
- [ ] **JUnit 5 Integration**: Expand the test suite in `jatp-core` to cover edge cases for `Spoon` analysis results.
- [ ] **Documentation Examples**: Add a set of example Eclipse RCP project paths and test cases to the User Guide.

## 🟡 Help Wanted (Intermediate)
- [ ] **Spoon-based Navigation Analysis**: Use Spoon to analyze method calls between `ViewPart` classes to automatically populate the `reachableFrom` list in `Screen` models.
- [ ] **Enhanced SWT Tree Traversal**: Implement a more robust path-generation logic for `SwtTreeInspector` (e.g., `Shell -> Composite -> Button`).
- [ ] **Custom AI Provider Wrapper**: Implement a new `LlmProvider` for a specific model (e.g., DeepSeek or Qwen) using LangChain4j.

## 🔴 Core Features (Advanced)
- [ ] **AI Navigation Agent**: Implement the `ScreenerAgent` that takes the current `AppState` and `ScreenMap` and outputs a `Widget` ID to interact with.
- [ ] **Self-Healing Locators**: Implement a fallback mechanism that uses LLM visual reasoning to find a widget when the `widgetId` is no longer valid.
- [ ] **Multi-Agent Coordination**: Use LangGraph to coordinate the `PlannerAgent`, `ScreenerAgent`, and `ValidationAgent`.
- [ ] **OpenAPI Generator**: Build the logic to transform a successful `TestCase` execution trace into an OpenAPI 3.0 YAML specification.

## 🚀 Enterprise Hardening
- [ ] **Persistence Layer**: Integrate PostgreSQL to save discovered `ScreenMaps` and `TestCase` execution histories.
- [ la- la la] **Kafka Integration**: Implement an event-driven architecture for async test execution and monitoring.
- [ ] **Allure Reporting**: Generate rich HTML reports for test execution results.
