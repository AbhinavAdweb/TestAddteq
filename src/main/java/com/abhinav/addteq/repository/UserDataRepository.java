package com.abhinav.addteq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhinav.addteq.model.UserData;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, String> {

}