package com.kiwiland.trains.model;

/**
 * Model class representing a town.
 */
public class Town {

    private String name;

    public Town(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Town other = (Town) obj;
        if (name == null) {
            return other.name == null;
        } else return name.equals(other.name);
    }

}
