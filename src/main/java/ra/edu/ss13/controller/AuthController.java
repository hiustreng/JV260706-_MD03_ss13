package ra.edu.ss13.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @GetMapping("/test")
    public ResponseEntity<String> testPublic() {
        return ResponseEntity.ok("Public endpoint accessed successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login() {
        return ResponseEntity.ok("đăng nhập thành công");
    }
}