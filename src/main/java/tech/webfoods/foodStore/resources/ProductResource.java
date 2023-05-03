package tech.webfoods.foodStore.resources;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.webfoods.foodStore.converters.ProductConverter;
import tech.webfoods.foodStore.dto.ProductDTO;
import tech.webfoods.foodStore.usecase.GetAllProducts;
import tech.webfoods.foodStore.usecase.SaveProduct;

@RestController
@RequestMapping("/api/v1/")
@AllArgsConstructor
@CrossOrigin(origins = "*")
@SecurityRequirement(name = "bearer-key")
public class ProductResource {


    private final SaveProduct saveProduct;

    private final GetAllProducts getAllProducts;

    @PostMapping(value = "/product/save")
    public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductDTO productDTO) {
        return saveProduct.execute(productDTO);
    }

    @GetMapping(value = "product/list")
    public ResponseEntity<Page<ProductDTO>> getAllProducts
            (@PageableDefault(sort = {"description"}) Pageable pageable) {
        var list = getAllProducts.execute(pageable).map(ProductConverter::toDTO);
        return ResponseEntity.ok(list);

    }

}
