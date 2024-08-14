# Calculator Android App

The Calculator app is a user-friendly and efficient tool designed to perform a wide range of mathematical calculations on your Android device. Whether you need to handle basic arithmetic or more complex operations, this app has you covered.

## Features

- **Basic Arithmetic**: Perform addition, subtraction, multiplication, and division with ease.
- **Advanced Functions**: Use advanced functions such as sine, cosine, and square root for more complex mathematical tasks.
- **Calculation History**: Conveniently review your previous calculations with the Calculations History feature.
- **Optimized Performance**: Designed to deliver quick and accurate results, ensuring a smooth user experience.


## Installation

To install the Calculator app on your Android device, follow these steps:

1. Clone this repository to your local machine:
    ```bash
    git clone https://github.com/saiedoc/CalculaterApp.git
    ```
2. Open the project in **Android Studio**.
3. Sync the Gradle files to resolve dependencies.
4. Build and run the project on an Android device or emulator.

## Prerequisites

Before running the project, make sure you have the following tools installed:

- **Android Studio**: [Download here](https://developer.android.com/studio)
- **Java SDK**: Version 8 or above
- **Kotlin**: Included in the project

## Project Structure

The project is built using **Android Studio** and follows standard Android development practices. It is structured as follows:

- **Main Package**: `mainpackage.ScientificCalculator`
- **UI Components**: Built with `ConstraintLayout` and `Material Components` for a modern, responsive UI.
- **Backend Logic**: Uses `exp4j` for evaluating mathematical expressions.
- **Database Support**: Implemented with Room to save and retrieve calculation history.

## Dependencies

- **Room**: Used for local data storage and retrieving the calculation history.
- **exp4j**: A simple mathematical expression evaluator used to handle all calculations.
- **Kotlin Standard Library**: Provides essential Kotlin features for Android development.
- **Material Components**: Provides a modern and visually appealing UI.

## Running the Application

To run the application:

1. Ensure that the **Gradle** files are synced.
2. Build and run the application using Android Studio by pressing the **Run** button or running the following command in the terminal:
    ```bash
    ./gradlew assembleDebug
    ```
3. The app should launch on the connected Android device or emulator.

## Author

**Saied Aussi**

If you have any questions or want to contribute to this project, feel free to reach out to me.

## License

This project is licensed under the ISC License.