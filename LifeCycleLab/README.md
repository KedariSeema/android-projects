# LifecycleLab

A small Android learning project created to understand and experiment with **Activity lifecycle, Fragment lifecycle, Fragment View lifecycle, ViewBinding, and Fragment back stack behavior**.

The project is intentionally simple. The main goal is to observe Android lifecycle behavior through **Logcat experiments** rather than building a feature-heavy application.

## What This Project Covers

* Activity lifecycle
* Fragment lifecycle
* Fragment View lifecycle
* `LifecycleOwner`
* `viewLifecycleOwner`
* Activity recreation during configuration changes
* Fragment back stack
* `addToBackStack()`
* `replace()` and Fragment navigation
* Fragment instance vs Fragment View
* ViewBinding lifecycle
* Clearing Fragment ViewBinding in `onDestroyView()`
* Lifecycle observation using `DefaultLifecycleObserver`
* Using Logcat to understand lifecycle transitions

## Project Structure

```text
LifecycleLab
│
├── MainActivity
│   └── Hosts the Fragment container
│
├── FirstFragment
│   ├── Fragment lifecycle logging
│   ├── Fragment View lifecycle logging
│   ├── ViewBinding
│   └── Navigation to SecondFragment
│
└── SecondFragment
    └── Fragment lifecycle logging
```

## Key Experiments

### 1. Activity Lifecycle

The app was tested through different user and system events such as:

* App launch
* Moving the app to the background
* Returning to the app
* Pressing Back
* Screen rotation

Example lifecycle sequence during a normal launch:

```text
onCreate()
onStart()
onResume()
```

During rotation, the existing Activity is destroyed and a new Activity instance is created because of the configuration change.

---

### 2. Fragment Lifecycle

The project logs the major Fragment lifecycle callbacks:

```text
onAttach()
onCreate()
onCreateView()
onViewCreated()
onStart()
onResume()
onPause()
onStop()
onDestroyView()
onDestroy()
onDetach()
```

This was used to understand the difference between the lifetime of the Fragment object and the lifetime of its View.

---

### 3. Fragment View Lifecycle

One of the main experiments was observing the separate lifecycle of the Fragment's View using:

```kotlin
viewLifecycleOwner.lifecycle
```

The project uses `DefaultLifecycleObserver` to log View lifecycle events such as:

```text
VIEW → onCreate
VIEW → onStart
VIEW → onResume
VIEW → onPause
VIEW → onStop
VIEW → onDestroy
```

This helped demonstrate that a Fragment can remain alive even after its View has been destroyed.

---

### 4. Fragment Instance vs Fragment View

The project uses a simple counter and Fragment `hashCode()` to observe Fragment recreation behavior.

For example:

```text
FirstFragment onCreateView instance=155970492, count=1
```

After navigating to another Fragment and returning:

```text
FirstFragment onCreateView instance=155970492, count=2
```

The same Fragment instance was reused, while its View was created again.

This demonstrates an important Android concept:

> A Fragment object can survive while its View is destroyed and later recreated.

---

### 5. Fragment Back Stack

The project also experiments with:

```kotlin
replace(...)
    .addToBackStack(null)
    .commit()
```

This demonstrates that `addToBackStack()` stores the **Fragment transaction** in the FragmentManager back stack.

When the transaction is popped using the system Back action, the previous Fragment state is restored and its View can be recreated.

---

### 6. ViewBinding Lifecycle

`FirstFragment` uses ViewBinding with a nullable backing property:

```kotlin
private var _binding: FragmentFirstBinding? = null

private val binding: FragmentFirstBinding
    get() = _binding!!
```

The binding is created when the Fragment View is created:

```kotlin
_binding = FragmentFirstBinding.inflate(
    inflater,
    container,
    false
)
```

and cleared when the View is destroyed:

```kotlin
override fun onDestroyView() {
    _binding = null
    super.onDestroyView()
}
```

This follows the Fragment View lifecycle:

```text
onCreateView()
      ↓
onViewCreated()
      ↓
UI interaction
      ↓
onDestroyView()
      ↓
_binding = null
```

The important idea is that ViewBinding should only be used while the Fragment's View exists.

## What I Learned

Through this project I practiced and verified:

* An Activity and Fragment have different lifecycles.
* A Fragment has both a **Fragment lifecycle** and a **View lifecycle**.
* `viewLifecycleOwner` represents the lifecycle of the current Fragment View.
* A Fragment's View can be destroyed while the Fragment object remains alive.
* The same Fragment instance can receive multiple `onCreateView()` calls.
* `addToBackStack()` works with Fragment transactions.
* `replace()` can destroy the current Fragment View.
* ViewBinding should be cleared in `onDestroyView()`.
* Logcat is useful for understanding Android lifecycle behavior in real applications.

## Technologies Used

* Kotlin
* Android SDK
* AndroidX Fragment
* AndroidX AppCompat
* ViewBinding
* FragmentManager
* Lifecycle APIs
* Android Studio

## Purpose of the Project

This is a **learning and interview-preparation project**, not a production application.

The purpose is to build practical understanding of Android lifecycle behavior that is commonly relevant when working with:

* UI state
* Fragment navigation
* configuration changes
* ViewBinding
* memory management
* lifecycle-aware components
* Android debugging

## Future Reference

This project is intentionally kept small so it can be revisited later when working on more advanced topics such as:

* ViewModel
* lifecycle-aware state handling
* Coroutines
* Flow
* Navigation
* configuration/state restoration


