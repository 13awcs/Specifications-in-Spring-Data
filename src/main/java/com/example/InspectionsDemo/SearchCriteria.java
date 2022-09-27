package com.example.InspectionsDemo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class SearchCriteria {
    private String key;
    private String operation;
    private Object value;

    public SearchCriteria(String key, String operation, Object value) {
        this.key = key;
        this.operation = operation;
        this.value = value;
    }

    private boolean orPredicate;
    public boolean isOrPredicate() {
        return orPredicate;
    }
    public void setOrPredicate(boolean orPredicate) {
        this.orPredicate = orPredicate;
    }
}
