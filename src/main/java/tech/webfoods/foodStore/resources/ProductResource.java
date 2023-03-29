 package tech.webfoods.foodStore.resources;

 import lombok.AllArgsConstructor;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.CrossOrigin;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;
 import tech.webfoods.foodStore.dto.ProductDTO;
 import tech.webfoods.foodStore.model.Product;
 import tech.webfoods.foodStore.service.CustomerService;
 import tech.webfoods.foodStore.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class ProductResource {



    public ResponseEntity<Product> saveProduct(ProductDTO productDTO){

        return null;
    }



}
