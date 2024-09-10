package spring_learn.demo.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring_learn.demo.Service.RoleService;
import spring_learn.demo.dto.request.RoleRequest;
import spring_learn.demo.dto.response.ApiResponse;
import spring_learn.demo.dto.response.RoleResponse;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;


    @PostMapping
    public ApiResponse<RoleResponse> create(@RequestBody RoleRequest request){

        return ApiResponse.<RoleResponse>builder()
                .result(roleService.create(request))
                .build();
    }

    @GetMapping
    public ApiResponse<List<RoleResponse>> getAll(){
        return ApiResponse.<List<RoleResponse>>builder()
                .result(roleService.getAll())
                .build();
    }

    @DeleteMapping("/{role}")
    public ApiResponse<Void> delete(@PathVariable String role){

        roleService.delete(role);
        return ApiResponse.<Void>builder()
                .build();
    }


}
