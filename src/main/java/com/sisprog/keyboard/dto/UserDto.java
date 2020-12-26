package com.sisprog.keyboard.dto;

import com.sisprog.keyboard.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private Integer active;
    private String roles;
    private String permissions = "";
    private Long levelId;

    public static UserDto of(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setActive(user.getActive());
        dto.setRoles(user.getRoles());
        dto.setPermissions(user.getPermissions());
        dto.setLevelId(user.getLevelId());
        return dto;
    }
}
