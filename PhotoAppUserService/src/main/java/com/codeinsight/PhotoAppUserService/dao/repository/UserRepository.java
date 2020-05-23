package com.codeinsight.PhotoAppUserService.dao.repository;

import com.codeinsight.PhotoAppUserService.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {


}
