package com.soft.app.data.repos;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.soft.app.data.entity.ClassRoom;

public interface ClassRoomRepository extends CrudRepository<ClassRoom, Integer> {

	Optional<ClassRoom> findByName(String name);

}
