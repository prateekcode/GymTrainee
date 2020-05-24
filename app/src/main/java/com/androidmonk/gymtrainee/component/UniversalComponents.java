package com.androidmonk.gymtrainee.component;

import com.androidmonk.gymtrainee.Module.UniversalDaggerModule;
import com.androidmonk.gymtrainee.ui.WorkoutListActivity;
import com.androidmonk.gymtrainee.ui.FavoriteActivity;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {UniversalDaggerModule.class})
public interface UniversalComponents {
    public void inject(WorkoutListActivity workoutListActivity);
    public void inject(FavoriteActivity favoriteActivity);

}
