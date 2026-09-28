# IntentLab

A small Android learning project created to explore and understand **Android Intents** through hands-on experiments.

The project demonstrates explicit and implicit Intents, passing data between Activities, opening external applications, using a chooser, handling cases where no suitable Activity is available, and reusing an existing Activity with `FLAG_ACTIVITY_SINGLE_TOP`.

The UI is intentionally simple so the focus remains on understanding Android behavior and observing results through the application and Logcat.

## What This Project Covers

* Explicit Intent
* Implicit Intent
* Intent extras for passing data
* Intent actions
* Intent data and `Uri`
* Opening a web URL
* Sharing text using an Intent
* App chooser
* Handling `ActivityNotFoundException`
* Intent flags
* `FLAG_ACTIVITY_SINGLE_TOP`
* `onNewIntent()`
* Activity reuse
* Activity back-stack behavior
* Intent resolution

## Project Structure

```text
IntentLab
│
├── MainActivity
│   ├── Launch Activity
│   ├── Share Text
│   ├── View Site
│   └── Test Error
│
├── SecondActivity
│   ├── Displays data received from MainActivity
│   └── Reuse Activity experiment
│
├── IntentConstants.kt
│   └── Intent keys and Logcat tag
│
└── screenshots
    ├── Main screen
    ├── Second Activity
    ├── App chooser
    ├── Error handling
    └── Logcat
```

## Intent Experiments

### Launch Activity — Explicit Intent

The first experiment demonstrates an **explicit Intent**.

MainActivity directly specifies SecondActivity as the destination and passes small pieces of data through Intent extras.

SecondActivity receives the data and displays it on the screen.

This demonstrates how one Activity can explicitly launch another Activity and provide initial input.

### Share Text — Implicit Intent

The second experiment demonstrates an **implicit Intent** using a send action.

The application provides text and allows Android to find applications capable of receiving that content.

This demonstrates Intent-based communication between the application and other installed applications.

### View Site — Implicit Intent

The third experiment demonstrates an **implicit Intent with a web URL**.

The application requests that the URL be viewed without specifying a particular browser.

Android resolves an application capable of handling the web request.

### Test Error — No Matching Activity

The fourth experiment demonstrates what happens when no installed Activity can handle an Intent.

The application intentionally sends an unsupported action and handles the resulting `ActivityNotFoundException`.

Instead of allowing the application to fail, it displays an error message explaining that no suitable Activity is available.

### Reuse Activity — `FLAG_ACTIVITY_SINGLE_TOP`

The fifth experiment demonstrates Activity reuse.

SecondActivity launches SecondActivity again using `FLAG_ACTIVITY_SINGLE_TOP`.

Because the existing SecondActivity is already at the top of the task, Android reuses that Activity instance and delivers the new Intent through `onNewIntent()` instead of creating another Activity instance.

This experiment is verified using both the application UI and Logcat.

## Activity Reuse Flow

```text
MainActivity
     ↓
SecondActivity
     ↓
Reuse Activity
     ↓
FLAG_ACTIVITY_SINGLE_TOP
     ↓
Existing SecondActivity reused
     ↓
onNewIntent()
```

The important observation is that the existing Activity instance is reused when it is already at the top of the task.

## Key Concepts Learned

### Explicit vs Implicit Intent

An explicit Intent identifies a specific component.

An implicit Intent describes an action and optional data, allowing Android to find a suitable component.

### Intent Extras

Intent extras can be used to pass small pieces of data between components, such as IDs or short messages.

### Intent Actions

Actions describe the operation that should be performed, such as viewing or sending content.

### Intent Data

Intent data is commonly represented using a `Uri` and can be used to describe the resource or content associated with an action.

### Intent Resolution

For implicit Intents, Android looks for components that can handle the requested action, data, and categories.

### App Chooser

When multiple applications can handle an operation, an Intent chooser can allow the user to select the application to use.

### ActivityNotFoundException

An implicit Intent may fail when no installed application can handle the request. This project demonstrates handling that situation gracefully.

### `FLAG_ACTIVITY_SINGLE_TOP`

This flag allows an existing Activity at the top of the task to be reused instead of creating another instance.

### `onNewIntent()`

When an existing Activity is reused for a new Intent, the new Intent can be delivered through `onNewIntent()`.

## Screenshots

### Main Screen

The main screen provides access to all Intent experiments.

![IntentLab Main Screen](screenshots/main_screen.png)

### Second Activity

Shows the data received from MainActivity through Intent extras.

![Second Activity](screenshots/second_activity.png)

### App Chooser

Demonstrates the chooser displayed when multiple applications can handle the Share Text request.

![App Chooser](screenshots/app_chooser.png)

### Error Handling

Demonstrates the message shown when no Activity can handle the requested Intent.

![No Activity Found](screenshots/no_activity_found.png)

### Logcat

Demonstrates the Activity reuse experiment, including `onNewIntent()` being called instead of creating another Activity instance.

![Logcat](screenshots/logcat_on_new_intent.png)

## Technologies Used

* Kotlin
* Android SDK
* AndroidX AppCompat
* Intent API
* Activity lifecycle APIs
* `Uri`
* `ActivityNotFoundException`
* Logcat

## Topics Covered

* Android Intent
* Explicit Intent
* Implicit Intent
* Intent extras
* Intent action
* Intent data
* URI handling
* Intent resolution
* Chooser
* ActivityNotFoundException
* Intent flags
* `FLAG_ACTIVITY_SINGLE_TOP`
* `onNewIntent()`
* Activity instance reuse
* Activity back stack

## Purpose of the Project

This is a **learning and interview-preparation project**, not a production application.

The purpose of the project is to build practical understanding of how Android Intents work and how Activities communicate with other Activities and installed applications.

It also serves as a small reference project that can be revisited when preparing for Android interviews.
