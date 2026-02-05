package controller;

import entity.Company;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import service.CompanyService;

import java.util.List;

@RestController
@RequestMapping("api/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> findAll(){
        return companyService.findAll();
    }

    @GetMapping("/{id}")
    public Company findById(@PathVariable Long id){
        return companyService.findById(id);
    }

    @PostMapping
    public Company create (@Valid @RequestBody Company obj) {
        return companyService.create(obj);
    }

    @PutMapping("/{id}")
    public Company update (@PathVariable Long id, @Valid @RequestBody Company obj){
        return companyService.update(id, obj);
    }

    @DeleteMapping("/{id}")
    public Void delete (@PathVariable Long id){
        companyService.delete(id);
        return null;
    }
}
