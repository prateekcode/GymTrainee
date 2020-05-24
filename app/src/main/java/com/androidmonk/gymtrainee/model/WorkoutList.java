package com.androidmonk.gymtrainee.model;

public class WorkoutList {
    private String workout_name;
    private int image_id;

    public WorkoutList(String workout_name, int image_id) {
        this.workout_name = workout_name;
        this.image_id = image_id;
    }

    public String getWorkout_name() {
        return workout_name;
    }

    public void setWorkout_name(String workout_name) {
        this.workout_name = workout_name;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }
}
