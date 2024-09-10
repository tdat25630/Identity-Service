package spring_learn.demo.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring_learn.demo.Service.PermissionService;
import spring_learn.demo.dto.request.PermissionRequest;
import spring_learn.demo.dto.response.ApiResponse;
import spring_learn.demo.dto.response.PermissionResponse;

import java.util.List;

@RestController
@RequestMapping("/permissions")
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;


    @PostMapping
    public ApiResponse<PermissionResponse> create(@RequestBody PermissionRequest request){

        return ApiResponse.<PermissionResponse>builder()
                .result(permissionService.create(request))
                .build();
    }

    @GetMapping
    public ApiResponse<List<PermissionResponse>> getAll(){
        return ApiResponse.<List<PermissionResponse>>builder()
                .result(permissionService.getALl())
                .build();
    }

    @DeleteMapping("/{permission}")
    public ApiResponse<Void> delete(@PathVariable String permission){

        permissionService.delete(permission);
        return ApiResponse.<Void>builder()
                .build();
    }


}
