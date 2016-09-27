package checkout.gateway;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import checkout.entities.ProductDTO;

@FeignClient(name="catalog-service", path="/catalog")
public interface CatalogClient {

    @RequestMapping(method = RequestMethod.GET)
    List<ProductDTO> getProducts();
}