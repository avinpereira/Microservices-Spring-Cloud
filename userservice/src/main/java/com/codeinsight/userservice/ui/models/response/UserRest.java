package com.codeinsight.userservice.ui.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserRest {
    private String firstName;
    private String lastName;
    private String email;
    private String userId;
}
