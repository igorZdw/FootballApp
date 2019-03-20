package com.akademia.kodu.AplikacjaSpring.models;

import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
public class Target {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String description;
    private int reward = 10000;
    protected  int length = 8;
    private boolean started = false;
    private boolean ended = false;
    protected LocalDateTime startDate;

    public Target(String description) {

        this.description = description;
    }
    public Target(){}

    @Override
    public String toString() {
        return "Target{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", reward=" + reward +
                ", length=" + length +
                ", started=" + started +
                ", ended=" + ended +
                '}';
    }
    public Target(int id, String description){
        this.id = id;
        this.description = description;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        if (started) {
            this.startDate = LocalDateTime.now();
        }
    }

    public boolean isEnded() {
        if (this.ended) {
            return this.ended;
        } else {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime targetEndDate = this.startDate.plusSeconds(this.length);
            boolean isAfter = now.isAfter(targetEndDate);
            if (isAfter) {
                this.ended = true;
            }
            return isAfter;
        }


    }
}
