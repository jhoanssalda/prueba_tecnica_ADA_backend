package service.impl;

import entity.Company;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.CompanyRepository;
import service.CompanyService;

import java.util.List;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository repository;

    public CompanyServiceImpl(CompanyRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Company> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Company findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Company create(Company obj) {
        return repository.save(obj);
    }

    @Override
    public Company update(Long id, Company obj) {
        if (repository.existsById(id)) {
            obj.setId_company(id);
            return repository.save(obj);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
