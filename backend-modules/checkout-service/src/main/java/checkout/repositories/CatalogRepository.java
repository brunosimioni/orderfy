package checkout.repositories;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import checkout.entities.Product;

@FeignClient(name="catalog-service", path="/catalog")
public interface CatalogRepository {

    @RequestMapping(method = RequestMethod.GET)
    List<Product> getProducts();
}