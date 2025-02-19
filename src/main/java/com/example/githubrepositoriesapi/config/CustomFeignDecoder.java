package com.example.githubrepositoriesapi.config;

import com.example.githubrepositoriesapi.infrastructure.error.UserNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.coyote.BadRequestException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;

public class CustomFeignDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        if(response.status() == 404) {
            return new UserNotFoundException("User not found");
        }

        return new Exception("Exception while getting repositories details");
    }
}
