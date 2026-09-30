package org.v0x00v.usersignin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    @GetMapping("test_endpoint")
    public String testEndpoint()
    {
        return "{\"Success\": true}";
    }
}
