package tech.webfoods.foodStore.resources;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import tech.webfoods.foodStore.converters.CustomerConverter;
import tech.webfoods.foodStore.converters.EmployeeConverter;
import tech.webfoods.foodStore.dto.*;
import tech.webfoods.foodStore.usecase.*;

@RestController
@RequestMapping("/api/v1/")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class PersonResource {

    private final SaveCustomer saveCustomer;

    private final GetAllCustomers getAllCustomers;

    private final DetailCustomer detailCustomer;

    private final GetAllEmployee getAllEmployee;

    private final SaveEmployee employeeService;

    private final DeleteCustomer deleteCustomer;

    private final DeleteEmployee deleteEmployee;



    @PostMapping(value = "/customer/save")
    public ResponseEntity<PersonDTO> saveCustomer(@RequestBody @Valid SaveCustomerDTO customerDTO, UriComponentsBuilder uriBuilder) {
        var customer = saveCustomer.execute(customerDTO);
        var uri = uriBuilder.path("/customer/save/{id}").buildAndExpand(customer.getId()).toUri();
        return ResponseEntity.created(uri).body(CustomerConverter.toDTO(customer));
    }


    @SecurityRequirement(name = "bearer-key")
    @PostMapping(value = "/employee/save")
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody @Valid SaveEmployeeDTO saveEmployeeDTO) {
            var employee = employeeService.execute(saveEmployeeDTO);
        return ResponseEntity.ok(EmployeeConverter.toDTO(employee));
    }

    @SecurityRequirement(name = "bearer-key")
    @GetMapping(value = "/customer/customers")
    public ResponseEntity<Page<CustomerDTO>> listCustomer(
            @PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        var list = getAllCustomers.execute(pageable).map(CustomerConverter::toDTO);
        return ResponseEntity.ok(list);
    }

    @SecurityRequirement(name = "bearer-key")
    @GetMapping(value = "/customer/customers/{id}")
    public ResponseEntity<CustomerDTO> detailCustomer(@PathVariable Long id) {
        var customer = detailCustomer.execute(id);
        return ResponseEntity.ok(customer);
    }

    @SecurityRequirement(name = "bearer-key")
    @DeleteMapping(value = "/customer/customers/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        var isRemoved = deleteCustomer.execute(id);
        if (isRemoved) {
            return ResponseEntity.status(HttpStatus.OK).body("Cliente excluído com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
    }

    @SecurityRequirement(name = "bearer-key")
    @DeleteMapping(value = "/employee/employeers/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        var isRemoved = deleteEmployee.execute(id);
        if (isRemoved) {
            return ResponseEntity.status(HttpStatus.OK).body("Funcionario excluído com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionario não encontrado.");
        }
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @SecurityRequirement(name = "bearer-key")
    @GetMapping(value = "/employee/employers")
    public ResponseEntity<Page<EmployeeDTO>> listEmployee(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        var list = getAllEmployee.execute(pageable).map(EmployeeConverter::toDTO);
        return ResponseEntity.ok(list);
    }

}
