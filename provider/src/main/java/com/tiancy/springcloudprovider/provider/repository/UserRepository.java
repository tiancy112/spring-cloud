package com.tiancy.springcloudprovider.provider.repository;

import com.tiancy.springcloudprovider.provider.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
}
