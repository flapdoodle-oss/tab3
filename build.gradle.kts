import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
  kotlin("jvm")
  id("org.jetbrains.compose")
}

group = "de.flapdoodle"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
  maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
  google()
}

dependencies {
  // Note, if you develop a library, you should use compose.desktop.common.
  // compose.desktop.currentOs should be used in launcher-sourceSet
  // (in a separate module for demo project and in testMain).
  // With compose.desktop.common you will also lose @Preview functionality
  implementation(compose.desktop.currentOs)
//  testImplementation("org.jetbrains.compose.ui:ui-test-junit4:1.4.0")
//  testImplementation("androidx.compose.ui:ui-test-manifest:1.3.0")
//  testImplementation(kotlin("test"))
//  testImplementation("org.assertj:assertj-core:3.24.2")
//  testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
//  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")

  implementation(kotlin("test"))
  implementation(kotlin("test-common"))
  implementation(kotlin("test-annotations-common"))
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
  implementation("io.mockk:mockk:1.12.5")
  // kotest
  implementation("io.kotest:kotest-runner-junit5:5.3.1")
  implementation("io.kotest:kotest-assertions-core:5.3.1")
  implementation("io.kotest:kotest-property:5.3.1")
//  // ktor
//  implementation("io.ktor:ktor-client-mock:$ktorVersion")
  // Compose
//  implementation(compose("org.jetbrains.compose.ui:ui-test-junit4:1.0.0"))
  implementation("org.jetbrains.compose.ui:ui-test-junit4:1.5.3")
  implementation("org.junit.jupiter:junit-jupiter:5.9.2")
  implementation("org.junit.vintage:junit-vintage-engine:5.9.2")
}

tasks.test {
  useJUnitPlatform()
}

compose.desktop {
  application {
    mainClass = "MainKt"

    nativeDistributions {
      targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
      packageName = "tab3"
      packageVersion = "1.0.0"
    }
  }
}
