package com.myown.game.test.Stream;

import java.math.BigDecimal;

public class Employee {

    private Integer id ;

    private String name;

    private Integer age;

    private double salary;

    public Employee(Integer id, String name, Integer age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int hashCode() {
        int result;
        long temp = Double.doubleToLongBits(salary);
        result = id;
        result = 31*result+(name==null?0:name.hashCode());
        result = 31*result+age;
        result = 31*result+(int)(temp^temp>>>32);
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if(id.equals(((Employee)obj).getId())){
            return true;
        }else{
            return false;
        }
    }


}
