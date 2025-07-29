plugins {
	alias(libs.plugins.loom)
}

repositories {
	mavenCentral()
}

version = property("mod_version") as String
group = property("maven_group") as String

dependencies {
	minecraft(libs.minecraft)
	mappings(variantOf(libs.yarn) { classifier("v2") })
	modImplementation(libs.fabricLoader)
}

tasks {
	processResources {
		val props = mapOf(
			"version" to version,
			"loader_version" to libs.versions.fabricLoader.get(),
		)
		inputs.properties(props)
		filesMatching("fabric.mod.json") {
			expand(props)
		}
	}
	jar {
		from("LICENSE") {
			rename { "${it}_${base.archivesName.get()}" }
		}
	}
}
