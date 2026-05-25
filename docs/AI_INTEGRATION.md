# AI Integration & Code Understanding

This document explains how JavaAutoPilot uses AI to understand Java source code and application behavior.

## 1. The "Understanding" Pipeline

JavaAutoPilot does not simply feed raw source code into an LLM (which would exceed context windows and introduce noise). Instead, it uses a **Hybrid Analysis Pipeline**:

### Step A: Structural Extraction (Static Analysis)
The `jatp-analyzer` uses **JavaParser** and **Spoon** to perform a deep scan of the source code. It extracts:
- **Class Hierarchy**: Who extends `ViewPart` or `IViewPart` (identifying screens).
- **Widget Declarations**: Identifying `Button`, `Text`, `Combo` etc., and their variable names.
- **Method Calls**: Mapping how one view triggers another (navigation).

**Output**: A structured "Screen Map" (JSON).

### Step B: Contextual Enrichment (Runtime Inspection)
The `jatp-inspector` attaches to the running application. It confirms:
- Which screen is actually active.
- The real-time properties of widgets (current text, visibility).
- The values of global variables.

**Output**: A "Runtime State" snapshot.

### Step C: AI Reasoning (The LLM Layer)
The `jatp-ai` module combines the **Screen Map** and the **Runtime State** into a prompt for the LLM.

**Example Prompt Logic**:
> "The user wants to 'Save the Project'. According to the Screen Map, the active screen `ProjectSettingsView` has a widget `saveButton` (type: Button, label: 'Save'). The current runtime state confirms this button is enabled. What is the next action?"

**AI Decision**: `CLICK(saveButton)`

---

## 2. Configuration & Setup

### API Key Setup
You can provide your AI API key in two ways:

1. **Environment Variable (Recommended)**:
   Set the `AI_API_KEY` environment variable in your shell.
   ```bash
   export AI_API_KEY="your-api-key-here"
   ```

2. **Configuration File**:
   Edit `jatp-api/src/main/resources/application.yml` and replace `${AI_API_KEY}` with your actual key.

### Connecting Your Code
JavaAutoPilot can analyze your code from two sources:

1. **Local Workspace**:
   In `application.yml`, set `jatp.analyzer.source-path` to the absolute path of your Java project.
   Example: `/Users/tanmaya/Desktop/my-java-app/src`

2. **Git Repository**:
   Set `jatp.analyzer.git-repo-url` to the URL of the repository. The system will clone the repository into a temporary directory before starting the static analysis.

---

## 3. Summary of Data Flow

`Local Path / Git URL` $\rightarrow$ `Static Analysis Engine` $\rightarrow$ `Screen Map (JSON)` $\rightarrow$ `LLM Prompt` $\rightarrow$ `Automation Action` $\rightarrow$ `Runtime Validation`
