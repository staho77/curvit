package com.staho.ms.domain;

public enum PersonTitleEnum {

	MR("personTitleMr"),
	
	MRS("personTitleMrs"),
	
	MS("personTitleMs");
	
    private String key;
    
    private PersonTitleEnum(String key) {
        this.key = key;
    }
    
    public String getKey() {
        return key;
    }
}
