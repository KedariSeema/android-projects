# Activity & Fragment Lab

A hands-on Android project demonstrating **Activity and Fragment navigation, back stack behavior, data communication, and traditional vs modern Android APIs**.

## Overview

This project was created to understand and practice how Activities and Fragments work together in an Android application.

It demonstrates:

* Activity-to-Activity navigation
* Fragment navigation
* Activity back stack
* Fragment back stack
* `add()` vs `replace()`
* Passing data using Fragment Arguments
* Passing data using the Fragment Result API
* Returning data from an Activity
* Traditional Activity Result API
* Modern Activity Result API
* `findViewById`
* ViewBinding

---

## Project Structure

```text
ActivityFragmentLab
│
├── MainActivity
│   ├── Activity navigation
│   ├── Traditional Activity Result API
│   ├── Modern Activity Result API
│   │
│   ├── FirstFragmentOfMainActivity
│   │   └── Fragment Arguments
│   │
│   └── SecondFragmentOfMainActivity
│       └── Reads Fragment Arguments
│
└── SecondActivity
    ├── ViewBinding
    ├── Activity Result
    │
    ├── FirstFragmentOfSecondActivity
    │   └── Fragment Result API - sends data
    │
    └── SecondFragmentOfSecondActivity
        └── Fragment Result API - receives data
```

---

## What This Project Demonstrates

### 1. Activity Navigation

`MainActivity` launches `SecondActivity` using an `Intent`.

The project also demonstrates how an Activity can return a result to the Activity that launched it.

---

### 2. Fragment Navigation

Fragments are displayed inside a `FragmentContainerView` using `FragmentManager`.

The project uses transactions such as:

```kotlin
supportFragmentManager
    .beginTransaction()
    .replace(R.id.fragmentContainer, FirstFragmentOfMainActivity())
    .addToBackStack(null)
    .commit()
```

This demonstrates how Fragment transactions can be added to the Fragment back stack.

---

### 3. Activity Back Stack

The project demonstrates Activity navigation using:

```text
MainActivity
      ↓
SecondActivity
```

When `SecondActivity` is started, it is placed on top of the existing Activity stack.

Calling `finish()` removes the current Activity from the stack.

---

### 4. Fragment Back Stack

Fragment transactions can also be added to a separate Fragment back stack.

For example:

```text
Fragment A
    ↓
Fragment B
```

When the transaction is added using:

```kotlin
.addToBackStack(null)
```

pressing Back can reverse the transaction and reveal the previous Fragment.

---

### 5. `add()` vs `replace()`

The project uses `replace()` for navigation between Fragments.

#### `replace()`

Removes the current Fragment from the container and places the new Fragment there.

#### `add()`

Adds another Fragment to the container without automatically removing the existing Fragment.

`add()` can therefore result in multiple Fragments being present at the same time.

---

### 6. Fragment Arguments

The project demonstrates passing initial data to a Fragment using a `Bundle`.

Conceptually:

```text
Fragment A
    │
    │ Bundle / Arguments
    ↓
Fragment B
```

Fragment arguments are useful when a Fragment needs initial input such as:

* ID
* Type
* Small configuration values
* Initial state

---

### 7. Fragment Result API

The project demonstrates communication between Fragments using the **Fragment Result API**.

Example flow:

```text
FirstFragment
      │
      │ Fragment Result
      ↓
SecondFragment
```

The sending Fragment uses a request key and `Bundle` to send data.

The receiving Fragment registers a listener for the same request key.

The listener uses `viewLifecycleOwner` so that UI updates are tied to the Fragment's View lifecycle.

---

### 8. Activity Result API

The project demonstrates both the older and modern approaches for receiving results from another Activity.

#### Traditional approach

Uses:

```text
startActivityForResult()
        ↓
onActivityResult()
```

This approach is included for comparison and understanding legacy Android code.

#### Modern approach

Uses:

```text
registerForActivityResult()
        ↓
ActivityResultLauncher
        ↓
launch()
```

The modern Activity Result API provides a lifecycle-aware way to register for and receive Activity results.

---

## Traditional vs Modern APIs

| Area                   | Traditional                | Modern                              |
| ---------------------- | -------------------------- | ----------------------------------- |
| View access            | `findViewById()`           | ViewBinding                         |
| Activity result        | `startActivityForResult()` | `registerForActivityResult()`       |
| Fragment communication | Bundle / direct patterns   | Fragment Result API                 |
| Fragment navigation    | Fragment transactions      | Fragment transactions + modern APIs |
| Lifecycle handling     | Manual callbacks           | Lifecycle-aware APIs                |

The traditional APIs are intentionally included in this project to understand older Android code and compare them with modern approaches.

---

## Technologies Used

* Kotlin
* Android SDK
* AndroidX
* AppCompat
* AndroidX Fragment
* ViewBinding
* ConstraintLayout
* Fragment Result API
* Activity Result API
* Gradle

---

## Key Concepts Practiced

* Activity lifecycle and navigation
* Fragment lifecycle basics
* Activity back stack
* Fragment back stack
* Fragment transactions
* `add()` vs `replace()`
* Fragment arguments
* Fragment Result API
* Activity Result API
* ViewBinding
* `findViewById()`
* Passing data between Android components
* Lifecycle-aware Fragment communication

---

## Purpose

The purpose of this project is to provide a small, focused environment for practicing and demonstrating **Activity/Fragment fundamentals and Android component communication** without the complexity of a large application.
