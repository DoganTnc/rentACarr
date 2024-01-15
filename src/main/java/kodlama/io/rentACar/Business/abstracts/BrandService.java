package kodlama.io.rentACar.Business.abstracts;

import kodlama.io.rentACar.Business.Requests.CreateBrandRequest;
import kodlama.io.rentACar.Business.Requests.UpdateBrandRequest;
import kodlama.io.rentACar.Business.Response.GetAllBrandsResponse;
import kodlama.io.rentACar.Business.Response.GetByIdBrandResponse;
import kodlama.io.rentACar.entities.concretes.Brand;

import java.util.List;


public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    GetByIdBrandResponse getById(int id);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);
}
