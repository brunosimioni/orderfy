package checkout.repositories;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import checkout.entities.Product;
import checkout.repositories.CatalogRepository.CatalogRepositoryFallback;

@FeignClient(name="catalog-service", path="/catalog" , fallback = CatalogRepositoryFallback.class)
public interface CatalogRepository {

    @RequestMapping(method = RequestMethod.GET)
    List<Product> getProducts();
    
    @RequestMapping(path="{id}", method = RequestMethod.GET)
    Product getProduct(@PathVariable("id") int id);
    
    @Component
    static class CatalogRepositoryFallback implements CatalogRepository {

		@Override
		public List<Product> getProducts() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Product getProduct(int id) {
			// TODO Auto-generated method stub
			return null;
		}
    }
}