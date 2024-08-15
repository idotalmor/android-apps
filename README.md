# Android App Project

## Overview

An Android app to list installed applications using Hilt, Room, and Jetpack Compose. Since I don't have a real device, the app was developed and tested on an emulator. Filtering for games was not implemented as the emulator has no games installed.

### Disclaimer

**Note:** The app was developed on an emulator. Real device behavior, especially retrieving installed apps, might differ.

## Tech Stack

- **Hilt**: Dependency injection.
- **Room**: Local storage for apps and user data.
- **Compose**: Modern UI toolkit.
- **ViewModel**: Lifecycle-aware UI data management.

## Architecture

Following Clean Architecture:
- **Use Cases**: Business logic.
- **Screens**: Composables for UI.
- **ViewModels**: Data management.
- **Repositories**: Data sources.

## Assumptions & Decisions

1. **App Storage**: Stored apps in Room due to lack of server support. Stored user data in Room too since the database was already set up. Might be overkill but follows Clean Architecture.
2. **User Data**: Age stored in Room; SharedPreferences might have been simpler.
3. **Navigation**: Uses Hilt for checking user existence, which might need refactoring.

## Potential Issues

- **Navigation with Hilt**: The current navigation logic relies on Hilt for dependency injection to check if a user exists. This approach could lead to issues and may require further investigation or refactoring for reliability.
- **Room Usage**: Storing apps and user data in Room might be overengineering, especially for single objects like user age. SharedPreferences could be a more lightweight solution.
- **Emulator Limitations**: As the app was only tested on an emulator, the absence of real-world data (like installed games) limits the scope of functionality testing. This could lead to unforeseen issues when run on actual devices.
