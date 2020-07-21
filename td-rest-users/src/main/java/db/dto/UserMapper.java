package db.dto;

import org.mapstruct.Mapper;
import db.quarkus.User;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface UserMapper {
    UserDto toDto(User user);

    List<UserDto> toDto(List<User> user);
}