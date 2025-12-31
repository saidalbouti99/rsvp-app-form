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

The application includes Unit Tests to ensure the reliability of the data layer:

Repository Tests: Verified using MockK to ensure correct delegation of API calls.

Validation Logic: (Optional) Tests the isInputValid logic within the ViewModel.

To run the tests, execute:

Bash
./gradlew test
📄 License
This project is licensed under the MIT License - see the LICENSE file for details.
