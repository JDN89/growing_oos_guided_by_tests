plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.assertj:assertj-swing:3.9.2")  // Added this line

    // Groovy
    implementation ("org.codehaus.groovy:groovy-all:3.0.9")
    implementation ("org.igniterealtime.smack:smack-java7:4.4.4")  // for Java 7+
    implementation ("org.igniterealtime.smack:smack-tcp:4.4.4"  )  // for TCP support
    testImplementation ("org.mockito:mockito-core:4.1.0")
    implementation ("com.jgoodies:forms:1.10.0")

    // Spock Framework for testing
    testImplementation ("org.spockframework:spock-core:2.0-groovy-3.0")
    testImplementation ("org.spockframework:spock-junit4:2.0-groovy-3.0")
}

tasks.test {
    useJUnitPlatform()
}