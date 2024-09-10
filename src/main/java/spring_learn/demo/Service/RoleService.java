package spring_learn.demo.Service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import spring_learn.demo.dto.request.RoleRequest;
import spring_learn.demo.dto.response.RoleResponse;
import spring_learn.demo.mapper.RoleMapper;
import spring_learn.demo.repository.PermissionRepository;
import spring_learn.demo.repository.RoleRepository;

import java.util.HashSet;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class RoleService {

    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;
    private final RoleMapper roleMapper;



    public RoleResponse create(RoleRequest request){

        var role = roleMapper.toRole(request);

        var permission = permissionRepository.findAllById(request.getPermissions());

        role.setPermissions(new HashSet<>(permission));

        role = roleRepository.save(role);

        return roleMapper.toRoleResponse(role);


    }

    public List<RoleResponse> getAll(){
        return roleRepository.findAll().
                stream().map(roleMapper::toRoleResponse)
                .toList();
    }

    public void delete(String role){
        roleRepository.deleteById(role);

    }

}
