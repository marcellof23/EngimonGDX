package com.ungabunga.model.entities;

import com.ungabunga.model.exceptions.DuplicateSkillException;
import com.ungabunga.model.exceptions.FeatureNotImplementedException;
import com.ungabunga.model.enums.CONSTANTS;
import com.ungabunga.model.enums.IElements;
import com.ungabunga.model.utilities.Pair;

import java.util.ArrayList;
import java.util.List;

public class Engimon {
    protected static int count = 0;
    protected int id;
    protected String name, species, slogan;
    protected int level, exp, cumulativeExp;
    protected List<IElements> elements;
    protected Pair<String, String> parentName, parentSpecies;
    protected List<Skill> skills;

    public Engimon(){

    }

    public Engimon(Engimon e) {
        this.id = e.id;
        this.name = e.name;
        this.species = e.species;
        this.slogan = e.slogan;
        this.elements = e.elements;
        this.skills = e.skills;
        this.level = e.level;
        this.parentName = e.parentName;
        this.parentSpecies = e.parentSpecies;
        this.exp = e.exp;
        this.cumulativeExp = e.cumulativeExp;
    }

    public Engimon(String name, String species, String slogan, int level, List<IElements> elements, List<Skill> skills, Pair<String, String> parentName, Pair<String, String> parentSpecies) {
        this.id = count++;
        this.name = name;
        this.species = species;
        this.slogan = slogan;
        this.elements = elements;
        this.skills = skills;
        this.level = level;
        this.parentName = parentName;
        this.parentSpecies = parentSpecies;
        this.exp = 0;
        this.cumulativeExp = 0;
    }

    public Engimon(String species, String slogan, List<IElements> elements, Skill skill){
        this.id = count++;
        this.name = species;
        this.species = species;
        this.slogan = slogan;
        this.elements = elements;
        ArrayList<Skill> skills = new ArrayList<>();
        skills.add(skill);
        this.skills = skills;
        this.level = 1;
        Pair<String,String> parentSpecies = new Pair<>("Unknown", "Unknown");
        this.parentName = parentSpecies;
        this.parentSpecies = parentSpecies;
        this.exp = 0;
        this.cumulativeExp = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getCumulativeExp() {
        return cumulativeExp;
    }

    public void setCumulativeExp(int cumulativeExp) {
        this.cumulativeExp = cumulativeExp;
    }

    public List<IElements> getElements() {
        return elements;
    }

    public void setElements(List<IElements> elements) {
        this.elements = elements;
    }

    public Pair<String, String> getParentName() {
        return parentName;
    }

    public void setParentName(Pair<String, String> parentName) {
        this.parentName = parentName;
    }

    public Pair<String, String> getParentSpecies() {
        return parentSpecies;
    }

    public void setParentSpecies(Pair<String, String> parentSpecies) {
        this.parentSpecies = parentSpecies;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void deleteSkill(String skillName) {
        for(int i = 0; i < this.skills.size(); i++) {
            if(this.skills.get(i).getSkillName() == skillName) {
                this.skills.remove(i);
            }
        }
    }

    public void addSkill(Skill skill) {
        this.skills.add(skill);
    }

    public void setSkills(List<Skill> skills) { this.skills = skills; }

    public Boolean isLevelUp() {
        return this.exp >= 100;
    }

    public Boolean isMaxLevel() {
        return this.cumulativeExp >= 1000;
    }

    public void addExp(int exp) {
        this.exp += exp;
        this.cumulativeExp += exp;
        if(this.isLevelUp()) {
            this.exp %= 100;
            this.level += 1;
        }
    }

    public void displayInfo() {
        System.out.println("======BASIC INFO======");
        System.out.println("ID \t\t:\t" + this.id);
        System.out.println("Name \t\t:\t" + this.name);
        System.out.println("Species \t:\t" + this.species);
        System.out.println("Level \t\t:\t" + this.level);
        System.out.println("Exp \t\t:\t" + this.exp);
        System.out.println("Cumulative Exp \t:\t" + this.cumulativeExp);
        System.out.println("Parents \t:\t");
        System.out.println("\t- " + this.parentName.getFirst() + " (" + this.parentSpecies.getFirst() + ")");
        System.out.println("\t- " + this.parentName.getSecond() + " (" + this.parentSpecies.getSecond() + ")");
        System.out.println("Slogan \t:\t" + this.slogan);
        this.displaySkills();
    }

    public void displaySkills() {
        System.out.println("======SKILLS======");
        for (int i = 0; i < this.skills.size(); i++) {
            this.skills.get(i).displaySkillInfo();
        }
    }

    public String displayInfoToString() {
        String str = new String();
        str += ("ID \t\t:\t " + this.id+ "\n");
        str += ("Name \t\t:\t " + this.name+ "\n");
        str += ("Species \t:\t " + this.species+ "\n");
        str += ("Level \t\t:\t " + this.level+ "\n");
        str += ("Exp \t\t:\t " + this.exp+ "\n");
        str += ("Cumulative Exp \t:\t " + this.cumulativeExp+ "\n");
        str += ("Parents \t:\t "+ "\n");
        str += ("\t- " + this.parentName.getFirst() + " (" + this.parentSpecies.getFirst() + ")"+ "\n");
        str += ("\t- " + this.parentName.getSecond() + " (" + this.parentSpecies.getSecond() + ")"+ "\n");
        str += ("Slogan \t:\t " + this.slogan + "\n");
        str += ("Elements \t:\t "+ "\n");
        for(int i = 0; i < this.elements.size(); i++) {
            str += ("\t- " + this.elements.get(i)+ "\n");
        }
        str += ("Skills \t:\t "+ "\n");
        for(int i = 0; i < this.skills.size(); i++) {
            str += ("\t- " + this.skills.get(i).getSkillName());
            if(i != this.skills.size()-1) {
                str += ("\n");
            }
        }
        return str;
    }

    public String displayInfoToStringDetailEngimon() {
        String str = new String();
        str += ("ID \t\t:\t " + this.id+ "\n");
        str += ("Name \t\t:\t " + this.name+ "\n");
        str += ("Species \t:\t " + this.species+ "\n");
        str += ("Level \t\t:\t " + this.level+ "\n");
        str += ("Exp \t\t:\t " + this.exp+ "\n");
        str += ("Cumulative Exp \t:\t " + this.cumulativeExp+ "\n");
        str += ("Parents \t:\t "+ "\n");
        str += ("\t- " + this.parentName.getFirst() + " (" + this.parentSpecies.getFirst() + ")"+ "\n");
        str += ("\t- " + this.parentName.getSecond() + " (" + this.parentSpecies.getSecond() + ")"+ "\n");
        str += ("Slogan \t:\t " + this.slogan + "\n");
        str += ("Elements \t:\t "+ "\n");
        for(int i = 0; i < this.elements.size(); i++) {
            str += ("\t- " + this.elements.get(i)+ "\n");
        }
        return str;
    }

    public void increaseMastery() {
        for (int i = 0; i < this.skills.size(); i++)
        {
            this.skills.get(i).addMasteryExp(25);
        }
    }

    public void learnSkill(Skill skill) throws DuplicateSkillException {
        boolean found = false;
        ArrayList<String> skillNames = new ArrayList<String>();
        for(int i = 0; i < this.skills.size(); i++) {
            skillNames.add(this.skills.get(i).getSkillName());
        }

        for(int i = 0; i < this.elements.size(); i++) {
            if(skill.getElements().contains(this.elements.get(i))) {
                found = true;
                if(skillNames.contains(skill.getSkillName())) {
                    throw new DuplicateSkillException("Skill already learned!!");
                } else if(this.skills.size() == CONSTANTS.MAXSKILL) {
                    throw new DuplicateSkillException("Blom diimplementasiin soalnya berhubungan ama GUI juga :'v");
                } else {
                    this.skills.add(skill);
                    break;
                }
            }
        }
        if(!found) {
            throw new DuplicateSkillException("Element not compatible!!");
        }
    }

    // I.S skill ada
//    public void unlearnSkill(Skill skill){
//        ArrayList<String> skillNames = new ArrayList<String>();
//        for(int i = 0; i < this.skills.size(); i++) {
//            skillNames.add(this.skills.get(i).getSkillName());
//        }
//        int skillIndex = -1;
//        for(int i=0;i < this.skills.size();i++){
//
//        }
//    }
}
