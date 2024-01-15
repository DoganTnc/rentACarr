package kodlama.io.rentACar.webApi.Controllers;

import jakarta.validation.Valid;
import kodlama.io.rentACar.Business.Requests.CreateBrandRequest;
import kodlama.io.rentACar.Business.Requests.UpdateBrandRequest;
import kodlama.io.rentACar.Business.Response.GetAllBrandsResponse;
import kodlama.io.rentACar.Business.Response.GetByIdBrandResponse;
import kodlama.io.rentACar.Business.abstracts.BrandService;
import kodlama.io.rentACar.Business.concrets.BrandManager;
import kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//annotation//bunu tarayacak bunu gördüğünde direk çalıştıracak
@RequestMapping("/api/brands")//adresleme
@AllArgsConstructor
public class BrandsController {
    private BrandService brandService;

    @GetMapping()//bu istek gelirse bu çalışacak
    public List<GetAllBrandsResponse> getAll(){

        return brandService.getAll();
    }
    @GetMapping("/{id}")//bu istek gelirse bu çalışacak
    public GetByIdBrandResponse getById(@PathVariable int id){

        return brandService.getById(id);
    }
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(CreateBrandRequest createBrandRequest){
        this.brandService.add(createBrandRequest);
    }@PutMapping
    public void update(@RequestBody @Valid() UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.brandService.delete(id);
    }
}
