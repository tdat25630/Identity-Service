package spring_learn.demo.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spring_learn.demo.dto.request.PermissionRequest;
import spring_learn.demo.dto.request.UserCreationRequest;
import spring_learn.demo.dto.request.UserUpdateRequest;
import spring_learn.demo.dto.response.PermissionResponse;
import spring_learn.demo.dto.response.UserResponse;
import spring_learn.demo.entity.Permission;
import spring_learn.demo.entity.User;
import spring_learn.demo.enums.Role;
import spring_learn.demo.exception.AppException;
import spring_learn.demo.exception.ErrorCode;
import spring_learn.demo.mapper.PermissionMapper;
import spring_learn.demo.mapper.UserMapper;
import spring_learn.demo.repository.PermissionRepository;
import spring_learn.demo.repository.UserRepository;

import java.util.HashSet;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class PermissionService {

        private final PermissionRepository permissionRepository;

        private final PermissionMapper permissionMapper;

        public PermissionResponse create(PermissionRequest request){
            Permission permission = permissionMapper.toPermission(request);
            permission = permissionRepository.save(permission);
            return permissionMapper.toPermissionResponse(permission);
        }

        public List<PermissionResponse>getALl(){
            var permission = permissionRepository.findAll();

            return permission.stream().map(permissionMapper::toPermissionResponse).toList();
        }

        public void delete(String name){
            permissionRepository.deleteById(name);
        }
}
