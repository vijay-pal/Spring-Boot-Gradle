package com.pal.rest.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public interface UserProjection {
	
	@JsonProperty("user_id")
	long getUserId();

	@JsonProperty("user_name")
	String getUserName();

	@JsonProperty("email")
	String getEmail();

	@JsonIgnore
	RoleProjection getRoles();

	interface RoleProjection {
		String getRoleName();
	}

	@JsonProperty("user_role")
	default String getRoleName() {
		return getRoles().getRoleName();
	}
}
