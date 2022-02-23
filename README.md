![With Light Themes](./image/banner.png)
# Compose News
Modular Android architecture which showcase Kotlin, MVVM, Navigation, Hilt, Coroutines, Jetpack Compose, Retrofit and Kotlin Gradle DSL.

## Features
* Modular Android App Architecture.
* MVVM Architecture + Repository design Pattern.
* Jetpack Libraries and Architecture Components.
* Kotlin Gradle DSL.
* Ready for Production

## Modules

Modules are collection of source files and build settings that allow you to divide a project into discrete units of functionality. In this case apart from dividing by functionality/responsibility, existing the following dependence between them. The project is divided into 4 Modules :

#### App module

The `:app` module is an [com.android.application](https://developer.android.com/studio/build/), which is needed to create the app bundle.

#### Core module

The `:core` module is an [com.android.library](https://developer.android.com/studio/projects/android-library) for serving network requests. Providing the data source for the many features that require it.

#### Common module

The `:common` module is an [com.android.library](https://developer.android.com/studio/projects/android-library) only contains code and resources which are shared between feature modules. Reusing this way resources, layouts, views, and components in the different features modules, without the need to duplicate code.

#### Feature module

The `:feature` module is an [com.android.library](https://developer.android.com/studio/projects/android-library) which is a module containing a specific feature, isolated from the rest in accordance with business logic.

## Getting started

There are a few ways to open this project.

### Android Studio

1. `Android Studio` -> `File` -> `New` -> `From Version control` -> `Git`
2. Enter `https://github.com/yodeput/NewsApp-Compose.git` into URL field an press `Clone` button

### Command-line + Android Studio

1. Run `git clone https://github.com/yodeput/NewsApp-Compose.git` command to clone project
2. Open `Android Studio` and select `File | Open...` from the menu. Select cloned directory and press `Open` button

### Project configuration

Add parameters in the locale.properties file as shown in the example below.

```properties
api_key="Your API Key"
```

You can get an Api Key from [NEWS API ORG](https://newsapi.org/) 

1. Open [NEWS API](https://newsapi.org/) -> `Get API Key?`
2. Paste copied key into `local.properties` with parameter (`api_key`)


## Tech Stack & Libraries

* 100% [Kotlin](https://kotlinlang.org/) based + [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) 
* [Android Jetpack](https://developer.android.com/jetpack)
   * [Compose](https://developer.android.com/jetpack/compose) Android’s modern toolkit for building native UI.
   * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) UI related data holder, lifecycle aware.
   * [Room](https://developer.android.com/topic/libraries/architecture/room) construct database.
   * [Navigation](https://developer.android.com/guide/navigation/) Android Jetpack's Navigation component helps you implement effective navigation.
   * [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) for dependency injection.
   * [App Startup]() Provides a straightforward, performant way to initialize components at application startup.
* [Timber](https://github.com/JakeWharton/timber) A logger.
* [Accompanist](https://github.com/google/accompanist) - A collection of extension libraries for Jetpack Compose.
* [Landscapist](https://github.com/skydoves/landscapist) Jetpack Compose image loading library that fetches and displays network images with Glide, Coil, and Fresco.
* [Sandwich](https://github.com/skydoves/sandwich) construct lightweight http API response and handling error responses.
* [Kotlin coroutines](https://developer.android.com/kotlin/coroutines) Executing code asynchronously.
* [StateFlow](https://developer.android.com/kotlin/flow/stateflow-and-sharedflow) is a state-holder observable flow that emits the current and new state updates to its collectors.
* [Retrofit](https://square.github.io/retrofit/) is a Type-safe HTTP client for Android, Java and Kotlin by Square.
* [Moshi](https://github.com/square/moshi) is a modern JSON library for Android and Java. It makes it easy to parse JSON format data.
* [OkHttp interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor) Logs HTTP requests and responses.
* [Mockito](https://github.com/mockito/mockito) which is the most popular Mocking framework for unit tests written in Java as well as Kotlin.

## Licence
    Designed and developed by 2022 yodeput (Yogi Dewansyah Putra)
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
       http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
