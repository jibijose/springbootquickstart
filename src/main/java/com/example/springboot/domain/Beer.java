package com.example.springboot.domain;

import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Document
public class Beer {

    @Field
    private String name;

    @Field
    private float abv;

    @Field("brewery_id")
    private String brewery;

    @Field
    private String description;

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getAbv() {
		return abv;
	}

	public void setAbv(float abv) {
		this.abv = abv;
	}

	public String getBrewery() {
		return brewery;
	}

	public void setBrewery(String brewery) {
		this.brewery = brewery;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Beer{");
        sb.append("name='").append(name).append('\'');
        sb.append(", abv=").append(abv);
        sb.append(", brewery='").append(brewery).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
