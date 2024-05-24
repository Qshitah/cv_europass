package ntt.cv.europass.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import ntt.cv.europass.entity.Address;
import ntt.cv.europass.entity.City;
import ntt.cv.europass.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends MainService<Address, Long> {

    @Autowired
    private final CityService cityService;

    public AddressService(JpaRepository<Address, Long> repository, CityService cityService) {
        super(repository);
        this.cityService = cityService;
    }


    @Override
    public Address save(Address entity) {
        if(entity == null){
            return  null;
        }
        City city = cityService.save(entity.getCity());
        entity.setCity(city);
        return super.save(entity);
    }
}