package com.projetos.todolist;

import java.util.Objects;

public class Tasks implements Comparable<Tasks> {
    String name, desc; int prior; String datatermino, categ,status;

    @Override
    public String toString() {
        return  name +
                "," + desc +
                "," + prior +
                "," + datatermino +
                "," + categ  +
                "," + status;
    }
    @Override
    public int compareTo(Tasks arg0) {
        if(this.prior < arg0.prior){
        return 0;
		}
		else if(this.prior > arg0.prior) return -1;

        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tasks tasks = (Tasks) o;
        return prior == tasks.prior && Objects.equals(name, tasks.name) && Objects.equals(desc, tasks.desc) && Objects.equals(datatermino, tasks.datatermino) && Objects.equals(categ, tasks.categ) && Objects.equals(status, tasks.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, desc, prior, datatermino, categ, status);
    }

    public Tasks(String name, String desc, int prior, String datatermino, String categ, String status) {
        this.name = name;
        this.desc = desc;
        this.prior = prior;
        this.datatermino = datatermino;
        this.categ = categ;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPrior() {
        return prior;
    }

    public void setPrior(int prior) {
        this.prior = prior;
    }

    public String getDatatermino() {
        return datatermino;
    }

    public void setDatatermino(String datatermino) {
        this.datatermino = datatermino;
    }

    public String getCateg() {
        return categ;
    }

    public void setCateg(String categ) {
        this.categ = categ;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
