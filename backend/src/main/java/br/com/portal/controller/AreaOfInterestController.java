@RestController
@RequestMapping("/api/areas")
public class AreaOfInterestController {

    @Autowired
    private AreaOfInterestService areaOfInterestService;

    @PostMapping
    public ResponseEntity<AreaOfInterest> createArea(@RequestBody AreaOfInterest area) {
        AreaOfInterest createdArea = areaOfInterestService.createAreaOfInterest(area);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdArea);
    }

    @GetMapping
    public ResponseEntity<List<AreaOfInterest>> getAllAreas() {
        List<AreaOfInterest> areas = areaOfInterestService.getAllAreas();
        return ResponseEntity.ok(areas);
    }
}
