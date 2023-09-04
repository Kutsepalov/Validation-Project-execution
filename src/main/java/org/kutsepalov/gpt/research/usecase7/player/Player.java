package org.kutsepalov.gpt.research.usecase7.player;

import java.util.List;

public class Player {

    private String name;
    private int age;
    private int experience;
    private List<Integer> skills;

    public static Player of(int age, int experience, List<Integer> skills) {
        Player instance = new Player();
        instance.setAge(age);
        instance.setExperience(experience);
        instance.setSkills(skills);
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public List<Integer> getSkills() {
        return skills;
    }

    public void setSkills(List<Integer> skills) {
        this.skills = skills;
    }
}
