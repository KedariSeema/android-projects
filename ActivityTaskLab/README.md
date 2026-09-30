# ActivityTaskLab

A small Android learning project created to understand **Activity Tasks, Activity Back Stack, launch modes, and Intent flags** through hands-on experiments.

The project uses multiple Activities and Logcat to observe how Android creates, reuses, removes, and restores Activity instances.

## What This Project Covers

* Android Task
* Activity Back Stack
* Activity instance creation and reuse
* `standard` launch mode
* `singleTop`
* `singleTask`
* `singleInstance`
* `onNewIntent()`
* `FLAG_ACTIVITY_SINGLE_TOP`
* `FLAG_ACTIVITY_CLEAR_TOP`
* `FLAG_ACTIVITY_NEW_TASK`
* `FLAG_ACTIVITY_CLEAR_TASK`
* `finish()`
* Back button behavior
* Home and Recents behavior

## Project Structure

```text id="4xk6a1"
ActivityTaskLab
│
├── MainActivity
├── SecondActivity
├── ThirdActivity
├── FourthActivity
└── screenshots
```

## Activity Task Experiments

### Activity Back Stack

Built a simple Activity flow:

```text id="7l4mpe"
A → B → C → D
```

Observed how Activities are added to the task stack and how pressing Back removes the top Activity and reveals the previous one.

### Standard Launch Mode

Launched the same Activity multiple times and verified through `hashCode()` that Android creates separate Activity instances.

### SingleTop

Used `singleTop` behavior to verify that an Activity already at the top of the stack is reused instead of creating another instance.

The reused Activity receives the new Intent through `onNewIntent()`.

### Clear Top

Used `FLAG_ACTIVITY_CLEAR_TOP` with the stack:

```text id="e2h7pn"
A → B → C → D
```

Launching B cleared the Activities above it.

The experiment also demonstrated that with the default `standard` behavior, the existing B instance can be destroyed and a new B instance created.

### Clear Top + SingleTop

Combined `FLAG_ACTIVITY_CLEAR_TOP` and `FLAG_ACTIVITY_SINGLE_TOP`.

Activities above B were removed, while the existing B instance was reused and received the new Intent through `onNewIntent()`.

### SingleTask

Configured an Activity with `singleTask` and observed that Android reused the existing Activity instance and removed Activities above it.

### SingleInstance

Experimented with `singleInstance` to observe its separate task behavior and Activity isolation.

### Reset Task

Used `FLAG_ACTIVITY_NEW_TASK` together with `FLAG_ACTIVITY_CLEAR_TASK` to clear the existing task and start a new root Activity.

This demonstrates how an Activity stack can be completely reset, such as after logout or authentication flows.

## Activity Reuse Flow

```text id="gj6x1u"
A → B → C → D
        │
        ├── CLEAR_TOP
        │      ↓
        │    A → B(new)
        │
        ├── CLEAR_TOP + SINGLE_TOP
        │      ↓
        │    A → B(same)
        │
        └── singleTask
               ↓
             A → B(same)
```

## Key Concepts Learned

* A **Task** represents a user's unit of work containing Activities.
* The **Activity Back Stack** maintains the order of Activities in a task.
* `startActivity()` normally adds a new Activity to the stack.
* `finish()` removes the current Activity.
* Back normally pops the top Activity.
* Home backgrounds the task rather than popping its Activities.
* `standard` can create multiple instances of the same Activity.
* `singleTop` reuses an Activity only when it is already at the top.
* `singleTask` can reuse an existing Activity and clear Activities above it.
* `singleInstance` places an Activity in its own task.
* `onNewIntent()` is used when an existing Activity instance receives a new Intent.
* Intent flags can change Activity and task behavior.

## Technologies Used

* Kotlin
* Android SDK
* AndroidX AppCompat
* Intent API
* Activity lifecycle APIs
* Logcat

## Topics Covered

* Android Tasks
* Activity Back Stack
* Activity launch modes
* `standard`
* `singleTop`
* `singleTask`
* `singleInstance`
* Intent flags
* `CLEAR_TOP`
* `SINGLE_TOP`
* `NEW_TASK`
* `CLEAR_TASK`
* `onNewIntent()`
* Activity instance management
* Back, Home, and Recents behavior

## Purpose of the Project

This is a **learning and interview-preparation project**, not a production application.

The purpose is to build practical understanding of Activity task management and navigation behavior and to provide a small reference project for Android interview preparation.
