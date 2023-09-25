package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity   //this annotation makes Alien class as entity class
//@Table(name="alien_table")   //it will create a new table called alien table.
public class Alien {
        @Id          //It is saying that aid is primary key
        private int aid;
        private String aname;
//        @Column(name="alien_color")   this will change the name of column from color to alien_color;
        private String color;
        private Certificate certi;

    public Certificate getCerti() {
        return certi;
    }

    public void setCerti(Certificate certi) {
        this.certi = certi;
    }

    public int getAid() {
            return aid;
        }

        public void setAid(int aid) {
            this.aid = aid;
        }

        public String getAname() {
            return aname;
        }

        public void setAname(String aname) {
            this.aname = aname;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

