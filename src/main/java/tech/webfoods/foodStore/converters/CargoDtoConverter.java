package tech.webfoods.foodStore.converters;

import tech.webfoods.foodStore.dto.CargoDTO;
import tech.webfoods.foodStore.model.Cargo;

public class CargoDtoConverter {

    public static CargoDTO toDTO(Cargo cargo){
        return CargoDTO.builder()
                .name(cargo.getName())
                .build();
    }

    public static Cargo toEntity(CargoDTO cargo){
        return Cargo.builder()
                .name(cargo.getName())
                .build();
    }
}
