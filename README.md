Cryptocurrency Tracker App

📌 Overview

A Jetpack Compose-based Android app that fetches real-time cryptocurrency data using the Coinpaprika API. The app follows the MVVM architecture and leverages Koin for dependency injection.

✨ Features

📊 Display real-time cryptocurrency prices and details.

🔍 Search for specific cryptocurrencies.

📈 View historical price trends (if implemented).

⚡ Optimized UI using Jetpack Compose.

🚀 Clean architecture with MVVM pattern.

# CryptoCurrency App

A Jetpack Compose-based Android app that fetches real-time cryptocurrency data using the Coinpaprika API. The app follows the MVVM architecture and leverages Koin for dependency injection.

## Koin
I am using koin for the first time for this project before I used to implement Dependency Injection with Hilt. I am completely new to Koin.

## Features

📊 Display real-time cryptocurrency list and details.

⚡ Optimized UI using Jetpack Compose.

🚀 Clean architecture with MVVM pattern.


## Tech Stack

Language: Kotlin

UI: Jetpack Compose

Architecture: MVVM (Model-View-ViewModel)

Dependency Injection: Koin

Networking: Retrofit


API: Coinpaprika API



🔧 Setup & Installation

Clone the repository:

git clone https://github.com/your-repo/crypto-tracker.git

Open the project in Android Studio.

Add your API key (if required) in the appropriate file.

Build and run the project on an emulator or device.

🏗️ Architecture

The app follows the MVVM pattern, ensuring a clean separation of concerns:

UI Layer (Jetpack Compose): Displays the cryptocurrency data.

ViewModel Layer: Manages UI-related data and logic.

Repository Layer: Fetches data from the Coinpaprika API.

Networking Layer (Retrofit): Handles API requests and responses.

Dependency Injection (Koin): Provides dependencies efficiently.

🔌 Dependencies

Add the following dependencies in build.gradle (Module: app):

// Retrofit
implementation("com.squareup.retrofit2:retrofit:2.9.0")
implementation("com.squareup.retrofit2:converter-gson:2.9.0")

// Koin
implementation("io.insert-koin:koin-android:3.5.0")
implementation("io.insert-koin:koin-androidx-compose:3.5.0")

// Jetpack Compose
implementation("androidx.compose.ui:ui:1.5.1")
implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")

🎯 Usage

Launch the app to see a list of top cryptocurrencies.

Tap on a coin to view detailed information.

Use the search functionality to find specific cryptocurrencies.

🚀 Future Improvements

📊 Implement historical price charts.

🌙 Add dark mode support.

🔔 Integrate push notifications for price alerts.

📡 Implement caching for offline support.

📜 License

This project is MIT Licensed. Feel free to modify and improve it!

