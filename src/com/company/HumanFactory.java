package com.company;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class HumanFactory {

    public int getHumanCount(int min, int max){
        int peopleNum = ThreadLocalRandom.current().nextInt(min, max);
        return peopleNum;
    }

    /**
     * При большом желании сюда можно запихать генератор имен.
     */
    public List<String> getHumansNames(int humanCount){
        List<String> humans = new ArrayList<>();

        for (int i=1; i<=humanCount; i++)
        {
            humans.add("Human"+ i);
        }

        return humans;
    }

    /**
     * Генерируем рандомный набор скилов для каждого танцора.
     * Может попасться танцор вообще без скилов, который пришел просто побухать.
     */
    public String getHumanSkills(List<String> skills){
        String personalSkills = "";

            Set<Integer> randomSkills = new HashSet<Integer>();
            Random rr = new Random();
            while (randomSkills.size() < ThreadLocalRandom.current().nextInt(1, skills.size()+1)) {
                randomSkills.add(rr.nextInt(skills.size()));
            }

            List<Integer> skillsId = new ArrayList<>();
            skillsId.addAll(randomSkills);

            for(int i=0; i<skillsId.size(); i++)
            {personalSkills = personalSkills + " " + skills.get(skillsId.get(i));}

        return personalSkills;
    }

}