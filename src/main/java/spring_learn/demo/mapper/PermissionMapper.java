package spring_learn.demo.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import spring_learn.demo.dto.request.PermissionRequest;
import spring_learn.demo.dto.request.UserCreationRequest;
import spring_learn.demo.dto.request.UserUpdateRequest;
import spring_learn.demo.dto.response.PermissionResponse;
import spring_learn.demo.dto.response.UserResponse;
import spring_learn.demo.entity.Permission;
import spring_learn.demo.entity.User;


@Mapper(componentModel = "spring")
public interface PermissionMapper {

    Permission toPermission(PermissionRequest request);
    PermissionResponse toPermissionResponse(Permission permission);


}
