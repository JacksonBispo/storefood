package tech.webfoods.foodStore.converters;


import tech.webfoods.foodStore.model.City;

public class CityConverter {

    public static City toEntity(Long idCity){
        return City.builder()
                .id(idCity)
                .build();
    }
}
