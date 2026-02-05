package mapper;

import dto.CompanyDTO;
import entity.Company;

public class CompanyMapper extends GenericMapper<Company, CompanyDTO>{
    @Override
    public CompanyDTO toDTO(Company entity) {
        if (entity == null) {
            return null;
        }
        return CompanyDTO.builder()
                .id_company(entity.getId_company())
                .codigoCompany(entity.getCodigoCompany())
                .nameCompany(entity.getNameCompany())
                .descriptionCompany(entity.getDescriptionCompany())
                .build();
    }

    @Override
    public Company toEntity(CompanyDTO dto) {
        if (dto == null) {
            return null;
        }
        return Company.builder()
                .id_company(dto.getId_company())
                .codigoCompany(dto.getCodigoCompany())
                .nameCompany(dto.getNameCompany())
                .descriptionCompany(dto.getDescriptionCompany())
                .build();
    }
}
