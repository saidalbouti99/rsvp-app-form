RSVP Form Application

A modern Android application demonstrating a robust implementation of an RSVP submission form. Built using Jetpack Compose, Koin Dependency Injection, and a clean MVVM + Repository architecture.

Features

Modern UI: Implements a custom Material 3 design with an overlapping card effect and stylized form fields.

Real-time Validation: Validates user input (email format, character limits, numeric constraints) before submission.

State Management: Uses Compose mutableStateOf inside ViewModels for reactive UI updates.

Dependency Injection: Modularized DI using Koin for network and feature-specific dependencies.

Focus Management: Automatically manages keyboard focus, including restoring focus to the first field after a successful reset.

Error Handling: Comprehensive handling of network errors and API-specific response codes.

Tech Stack

UI: Jetpack Compose (Material 3)

Asynchronous Work: Kotlin Coroutines

Networking: Retrofit 2 & OkHttp

DI: Koin

Architecture: MVVM + Repository Pattern

Testing: MockK & JUnit 4

📂 Project Structure

The project follows a Feature-based organization to ensure scalability and maintainability:
```text
com.example.rsvpform.features.rsvp/
├── di/             # Koin modules (Network and Feature modules)
├── models/         # Data classes (RsvpModel) and API Interfaces
├── repositories/   # Data abstraction layer (RsvpRepository)
├── viewmodels/     # UI logic and state handling (RsvpViewModel)
└── views/          # Composable UI components (RsvpScreen, Sections)

⚙️ Setup & Installation

Clone the repository:

Bash

git clone https://github.com/saidalbouti99/rsvp-app-form.git
Open in Android Studio: Ensure you are using the latest version of Ladybug or higher.

Sync Gradle: Wait for the dependencies to download.

Run the App: Target a device running API 26 (Oreo) or higher.

🧪 Testing

The application includes Unit Tests to ensure the reliability of the data layer.

How to Run Tests (Recommended)
The easiest way to run the tests is directly within **Android Studio**:

1. **Locate the test file**: Navigate to `app/src/test/java/com/example/rsvpform/RsvpRepositoryTest.kt`.
2. **Click the Play Button**: Click the green arrow icon (play button) located next to the class name or individual test methods.
3. **View Results**: The "Run" window at the bottom of the IDE will display the pass/fail status and logs.

> **Note**: This method is recommended as Android Studio automatically manages the Java Runtime (JDK) and environment paths for you.

📄 License
This project is licensed under the MIT License - see the LICENSE file for details.
