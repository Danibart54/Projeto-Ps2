@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User user) {
        Optional<User> foundUser = userService.findByEmail(user.getEmail());
        if (foundUser.isPresent() && new BCryptPasswordEncoder().matches(user.getPassword(), foundUser.get().getPassword())) {
            return ResponseEntity.ok(foundUser.get());
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
