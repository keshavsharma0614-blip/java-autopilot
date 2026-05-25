plugins {
    id("java-library")
}

dependencies {
    implementation(project(":jatp-core"))

    // Bytecode manipulation for Java Agent
    implementation("net.bytebuddy:byte-buddy:1.14.12")
    implementation("net.bytebuddy:byte-buddy-agent:1.14.12")

    // SWT is provided by the target application at runtime.
    // We use compileOnly so we can use the classes without bundling them.
    // compileOnly("org.eclipse.platform:org.eclipse.swt:3.124.0")

    implementation("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
}
