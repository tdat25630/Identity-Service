package spring_learn.demo.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import spring_learn.demo.entity.Role;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
     String id;
     String username;
     String firstName;
     String lastName;
     LocalDate dob;
     Set<RoleResponse> roles;

}
