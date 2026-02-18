package models;

import java.util.UUID;

public abstract class BaseEntity {
    protected String id;

    public BaseEntity() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }
}