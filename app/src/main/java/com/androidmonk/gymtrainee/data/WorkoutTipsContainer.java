package com.androidmonk.gymtrainee.data;

import java.util.Random;

public class WorkoutTipsContainer {

    private String[] tips = {
            "Conlon recommends cleaning up — at least what’s in your eye (or camera) view. “I’m notorious for throwing clothes all over the place, but if I’m taking the time to work out in the apartment, I will clean the space first to clear my mind,” she says.",
            "“Fresh air helps to wake me up and get ready [to work out],” Conlon says. “If it’s cold out, I’ll put on a diffuser with eucalyptus or peppermint.”",
            "“Every little bit counts, so do what you can,” Robbins says. “You can do squats anywhere. Even a 10-minute express workout counts.” She recommends peppering in a few pushups throughout the day between deadlines — aim to do 25 to 50 in total.",
            "“You don’t have to force it,” Robbins says. “If you don’t feel like working out, encourage yourself to start with five minutes, and, if you’re still not in the mood, give yourself permission to stop. Most likely, though, you’ll want to continue. Endorphins are magic.”",
            "Use a journal to track your progress and jot down any breakthroughs you may have.",
            "Work out during your workday.",
            "Take a day off between weight-lifting sessions.",
            "Don't use momentum instead of your abs to do the work. Keep your middle muscles contracted throughout the entire range of motion.",
            "To engage the deepest muscles of your abs during any exercise-or just sitting in a chair-try this: Inhale, then exhale and pull your belly button toward your spine, without hunching your shoulders forward (don't just suck in your belly).",
            "Don't let your routine become rote."
    };
    public String getTip(){
        int index = new Random().nextInt(tips.length);
        return tips[index];
    }
}
