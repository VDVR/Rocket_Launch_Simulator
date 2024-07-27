# Rocket Launch Simulator

## Overview

This is a console-based Rocket Launch Simulator. The simulator progresses through various stages of a rocket launch, including pre-launch checks, launch, and achieving orbit.

## Project Structure

RocketLaunchSimulator/
├── src/
│ ├── rocket/
│ │ ├── RocketLaunchSimulator.java
│ │ ├── commands/
│ │ │ ├── Command.java
│ │ │ ├── CommandFactory.java
│ │ │ └── CommandProcessor.java
│ │ ├── stages/
│ │ │ ├── LaunchStage.java
│ │ │ ├── PreLaunchStage.java
│ │ │ ├── SecondStage.java
│ │ │ └── Stage.java
│ │ │ └── StageContext.java
│ │ └── utils/
│ │ ├── Logger.java
│ │ └── QualityCheck.java
└── README.md

## Setup

1. Clone the repository:
    ```sh
    git clone https://github.com/yourusername/RocketLaunchSimulator.git
    ```

2. Navigate to the project directory:
    ```sh
    cd RocketLaunchSimulator
    ```

3. Compile the project:
    ```sh
    javac -d bin src/rocket/**/*.java
    ```

4. Run the application:
    ```sh
    java -cp bin rocket.RocketLaunchSimulator
    ```

## Commands

- `start_checks`: Perform pre-launch checks.
- `launch`: Launch the rocket if pre-launch checks are completed.
- `fast_forward [seconds]`: Fast forward the simulation by the given number of seconds.
- `exit`: Exit the simulator.

## Example Output

2024/07/27 14:32:15 - Rocket Launch Simulator started.
2024/07/27 14:32:20 - Enter command:
start_checks
2024/07/27 14:32:25 - Pre-Launch Checks: All systems are 'Go' for launch.
2024/07/27 14:32:25 - Fuel quality check passed.
2024/07/27 14:32:25 - Rocket status check passed.
2024/07/27 14:32:30 - Enter command:
launch
2024/07/27 14:32:35 - Launching...
2024/07/27 14:32:45 - Stage 1 complete. Transitioning to Stage 2.
2024/07/27 14:32:55 - Orbit achieved! Mission Successful.
2024/07/27 14:33:00 - Exiting Rocket Launch Simulator. Goodbye!
