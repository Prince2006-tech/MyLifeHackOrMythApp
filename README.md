# MyLifeHackOrMythApp

##  Project Purpose

This Android application was developed to address the common challenge faced by first-year university students in distinguishing practical life hacks from misleading urban myths circulating online.

The app forms part of a mobile development assignment and demonstrates the use of **Kotlin in Android Studio**, along with version control and automated builds using GitHub and GitHub Actions.

---

##  Application Overview

**MyLifeHackOrMythApp** is an interactive flashcard-style quiz that helps users test their ability to identify real-life productivity hacks versus common myths.

Users are presented with a series of statements and must decide whether each one is:

*  **Life Hack (True)**
*  **Urban Myth (False)**

The app provides instant feedback, tracks performance, and displays a final score with personalised feedback.

---

##  Features

###  User Interface (UI)

* **Welcome Screen**

  * Displays a brief description and welcome message
  * “Start” button to begin the quiz

* **Flashcard Question Screen**

  * Displays one statement at a time
  * Two answer buttons: **Hack (True)** and **Myth (False)**
  * “Next” button to move to the next question
  * Immediate feedback after each answer

* **Score Screen**

  * Displays total correct answers
  * Personalised feedback (e.g. *"Master Hacker!"* or *"Stay Safe Online!"*)
  * “Review” button to view all questions with correct answers and explanations

---

###  Core Functionality

* Sequential quiz with multiple questions
* Real-time feedback on answers
* Score tracking system
* Final results with performance-based feedback
* Review mode with explanations
* Restart/Retry functionality

---

##  Application Logic

### Welcome Screen Logic

* When the user clicks **Start**, they are navigated to the Flashcard Question Screen.

### Flashcard Question Logic

* Questions are displayed one at a time in a loop
* User selects an answer:

  * Feedback is shown (Correct/Incorrect)
  * Score is updated if correct
* User clicks **Next** to continue
* Process repeats until all questions are completed

### Score Screen Logic

* Final score is calculated after last question
* Feedback is displayed based on performance
* User can:

  * Review answers
  * Restart the quiz

---

##  Technical Implementation

* Developed using **Kotlin** in **Android Studio**
* Uses **Activity-based architecture**
* Navigation handled via **Intents**
* Data managed using a **data class for questions**
* Conditional logic used for scoring and feedback
* Edge-to-edge UI design implemented

---

##  Installation & Setup

```bash
git clone https://github.com/Prince2006-tech/MyLifeHackOrMythApp.git
```

1. Open **Android Studio**
2. Select: `Open → MyLifeHackOrMythApp`
3. Allow **Gradle Sync** to complete
4. Run the app on:

   * Emulator OR
   * Physical device (API 24+)

---

##  Testing

### Manual Testing

The following were verified:

* Navigation between screens works correctly
* All questions display properly
* Feedback messages are accurate
* Score calculation is correct
* Retry functionality works
* App handles screen rotation properly

### Automated Testing

* **GitHub Actions** used to:

  * Build the project automatically
  * Ensure code runs outside local environment

---

##  Version Control (GitHub)

* Repository initialized with a README
* Regular commits and updates pushed during development
* GitHub used for:

  * Code management
  * Collaboration tracking
  * Automated builds (GitHub Actions)

---

##  Documentation

This README serves as part of the project documentation and includes:

* Purpose of the app
* Design and functionality overview
* Technical implementation details
* Testing approach

---

##  Video Demonstration

A video walkthrough of the app showcasing its features has been created.
 The link is included in this repository (add your YouTube link here).

---

##  References

* GeeksforGeeks (2022) *How to Go Back to Previous Activity in Android?*
  https://www.geeksforgeeks.org/android/how-to-go-back-to-previous-activity-in-android/

* Stack Overflow (2018) *Why Android Studio emulator is extremely slow?*
  https://stackoverflow.com/questions/52600963/why-android-studio-emulator-is-extremely-slow

---




