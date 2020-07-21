package db.dto;

import org.mapstruct.Mapper;
import db.quarkus.User;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface UserMapper {
    @Mapping(target = "forename", source = "firstName")
    @Mapping(target = "name", source = "lastName")
    UserDto toDto(User user);

    List<UserDto> toDto(List<User> user);
}