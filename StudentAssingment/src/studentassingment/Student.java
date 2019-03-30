/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentassingment;

import java.util.ArrayList;

/**
 *
 * 
 */
public class Student {
  
    private int id;
    private String name;
    private String yearLevel;
    private ArrayList<Subject> subjects = new ArrayList<Subject>();
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

    public String getLevel() {
        return yearLevel;
    }

    public void setLevel(String yearLevel) {
        this.yearLevel = yearLevel;
    }

    public String getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(String yearLevel) {
        this.yearLevel = yearLevel;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }
      
    
}
