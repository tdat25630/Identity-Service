package spring_learn.demo.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import spring_learn.demo.dto.request.PermissionRequest;
import spring_learn.demo.dto.request.RoleRequest;
import spring_learn.demo.dto.response.PermissionResponse;
import spring_learn.demo.dto.response.RoleResponse;
import spring_learn.demo.entity.Permission;
import spring_learn.demo.entity.Role;


@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions",ignore = true)
    Role toRole(RoleRequest request);
    RoleResponse toRoleResponse(Role role);


}
