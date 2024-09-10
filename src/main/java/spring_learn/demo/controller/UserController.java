package spring_learn.demo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import spring_learn.demo.Service.UserService;
import spring_learn.demo.dto.response.ApiResponse;
import spring_learn.demo.dto.request.UserCreationRequest;
import spring_learn.demo.dto.request.UserUpdateRequest;
import spring_learn.demo.dto.response.UserResponse;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {


    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;


    @PostMapping
    ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest request){

       return ApiResponse.<UserResponse>builder()

               .result(userService.createUser(request))
               .build();

    }
    @GetMapping
    ApiResponse<List<UserResponse>> getUsers(){
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        ApiResponse<List<UserResponse>> apiResponse = new ApiResponse<>();

        log.info("Username: {}",authentication.getName());
        authentication.getAuthorities().forEach(grantedAuthority -> log.info(grantedAuthority.getAuthority()));


        apiResponse.setResult(userService.getUsers());

        return apiResponse;

    }

    @GetMapping("/myInfo")
    ApiResponse<UserResponse> getMyInfo(){

//        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
//        apiResponse.setResult(userService.getMyInfo());


        return ApiResponse.<UserResponse>builder()
                .result(userService.getMyInfo())
                .build();
    }


    @GetMapping("/{userId}")
    UserResponse getUser(@PathVariable("userId") String userId){
        return userService.getUser(userId);
    }

    @PutMapping("/{userId}")
    UserResponse updateUser(@PathVariable String userId,@RequestBody UserUpdateRequest request){
        return userService.updateUser(userId,request);
    }

    @DeleteMapping("/{userId}")
    ResponseEntity<ApiResponse<String>> deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setMessage("User deleted successfully");
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(apiResponse);
    }

}
