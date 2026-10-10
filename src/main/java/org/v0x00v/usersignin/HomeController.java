package org.v0x00v.usersignin;


import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home()
    {
        return "Hello";
    }

    @GetMapping("/secured")
    public String secured(){ return "Secured Endpoint."; }

}
