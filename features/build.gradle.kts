/*
 * Created by Yogi Dewansyah
 * URL: https://github.com/yodeput
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 2/23/22, 10:25 PM
 *
 */

import dependencies.AnnotationProcessorsDependencies
import dependencies.Dependencies
import extensions.addTestsDependencies

plugins {
    id("commons.android-library")
    id(BuildPlugins.NAVIGATION)
    id(BuildPlugins.HILT)
}

android {

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = BuildDependenciesVersions.COMPOSE
    }

    flavorDimensions += "environment"
    productFlavors {
        create("production") {
        }
        create("staging") {
        }
        create("dev") {
        }
    }
}

dependencies {
    api(project(BuildModules.CORE))

    implementation(Dependencies.APPCOMPAT)
    implementation(Dependencies.LIFECYCLE_EXTENSIONS)
    implementation(Dependencies.NAVIGATION_FRAGMENT)
    implementation(Dependencies.NAVIGATION_UI)
    implementation(Dependencies.MATERIAL)
    implementation(Dependencies.COIL)
    implementation(Dependencies.COMPOSE_LIVEDATA)
    implementation(Dependencies.COMPOSE_UI)
    implementation(Dependencies.COMPOSE_MATERIAL)
    implementation(Dependencies.COMPOSE_MATERIAL_ICON)
    implementation(Dependencies.COMPOSE_MATERIAL_3)
    implementation(Dependencies.COMPOSE_UI_TOOLING)
    implementation(Dependencies.COMPOSE_PREVIEW)
    implementation(Dependencies.COMPOSE_CONSTRAIN_LAYOUT)
    implementation(Dependencies.ACTIVITY_COMPOSE)
    implementation(Dependencies.ACC_SWIPE_REFRESH)
    implementation(Dependencies.ACC_PLACEHOLDER)
    implementation(Dependencies.ACC_PAGER)
    implementation(Dependencies.ACC_PAGER_INDICATOR)
    implementation(Dependencies.ACC_WEBVIEW)
    implementation(Dependencies.SKYDOVES)
    implementation(Dependencies.IMG_COIL)
    kapt(AnnotationProcessorsDependencies.HILT)

    addTestsDependencies()
}
