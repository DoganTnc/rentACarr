package kodlama.io.rentACar.Business.concrets;

import kodlama.io.rentACar.Access.abstracts.BrandRepository;
import kodlama.io.rentACar.Business.Requests.CreateBrandRequest;
import kodlama.io.rentACar.Business.Requests.UpdateBrandRequest;
import kodlama.io.rentACar.Business.Response.GetAllBrandsResponse;
import kodlama.io.rentACar.Business.Response.GetByIdBrandResponse;
import kodlama.io.rentACar.Business.abstracts.BrandService;
import kodlama.io.rentACar.Business.rules.BrandBusinessRules;
import kodlama.io.rentACar.core.utilitys.mappers.ModelMapperService;
import kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service //Bu sınıf bir business nesnesidir
@AllArgsConstructor
public class BrandManager implements BrandService {
    private ModelMapperService modelMapperService;
    private BrandRepository brandRepository;
private BrandBusinessRules brandBusinessRules;
    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands=brandRepository.findAll();
        List<GetAllBrandsResponse> brandsResponses=brands.stream()
                .map(brand -> this.modelMapperService.forResponse().map(brand,GetAllBrandsResponse.class)).collect(Collectors.toList());
        return brandsResponses;
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand=this.brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse response=this.modelMapperService.forResponse().map(brand,GetByIdBrandResponse.class);

        return response;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
        Brand brand=this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand=this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }
}
