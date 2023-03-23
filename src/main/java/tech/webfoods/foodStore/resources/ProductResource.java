 package tech.webfoods.foodStore.resources;

 import lombok.AllArgsConstructor;
 import org.springframework.web.bind.annotation.CrossOrigin;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;
 import tech.webfoods.foodStore.repository.DistrictRepository;
 import tech.webfoods.foodStore.service.CustomerService;
 import tech.webfoods.foodStore.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class ProductResource {

    private final CustomerService customerService;
    private final EmployeeService employeeService;

    private final DistrictRepository districtRepository;


}
