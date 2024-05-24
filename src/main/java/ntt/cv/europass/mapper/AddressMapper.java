package ntt.cv.europass.mapper;

import ntt.cv.europass.dto.AddressDTO;
import ntt.cv.europass.entity.Address;

public class AddressMapper {

    public static Address mapToEntity(AddressDTO dto) {
        if (dto == null) {
            return null;
        }

        return Address.builder()
                .id(dto.getId())
                .addressDescription(dto.getAddressDescription())
                .postalCode(dto.getPostalCode())
                .city(CityMapper.mapToEntity(dto.getCity()))
                .build();
    }
}
