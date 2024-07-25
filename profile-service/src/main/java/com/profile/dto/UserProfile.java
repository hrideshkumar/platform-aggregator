package com.profile.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {

	private int id;
    private String firstName;
    private String lastName;
    private int age;
    private List<String> hobbies;
}
