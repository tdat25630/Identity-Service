package spring_learn.demo.controller;


import com.nimbusds.jose.JOSEException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring_learn.demo.Service.AuthenticationService;
import spring_learn.demo.dto.response.ApiResponse;
import spring_learn.demo.dto.request.AuthenticationRequest;
import spring_learn.demo.dto.request.IntrospectRequest;
import spring_learn.demo.dto.response.AuthenticationResponse;
import spring_learn.demo.dto.response.IntrospectResponse;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor

public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/token")
    ApiResponse<AuthenticationResponse>authenticate(@RequestBody AuthenticationRequest request){
       var result =  authenticationService.authenticate(request);
       ApiResponse<AuthenticationResponse> apiResponse = new ApiResponse<>();


       apiResponse.setResult(result);

       return apiResponse;

//       return ApiResponse.<AuthenticationResponse>builder()
//               .result(result)
//
//               .build();
    }

    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse>authenticate(@RequestBody IntrospectRequest request)
            throws ParseException, JOSEException {
        var result =  authenticationService.introspectResponse(request);
        return ApiResponse.<IntrospectResponse>builder()
                .result(result)

                .build();
    }


}
